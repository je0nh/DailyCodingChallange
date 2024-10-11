import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPalindrome(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder();
        
        while (matcher.find()) {
            sb.append(matcher.group().toLowerCase());
        }
        
        System.out.println(sb.toString());
        
        String newString = sb.toString();
        int lastIndex = newString.length() - 1;
        if (lastIndex <= 0) {
            return true;
        }
        for (int i = 0; i <= (newString.length() - 1) / 2; i++) {
            System.out.println(newString.charAt(i) + " : " + newString.charAt(lastIndex));
            if (newString.charAt(i) != newString.charAt(lastIndex)) {
                return false;
            }
            lastIndex--;
        }
        return true;
    }
}
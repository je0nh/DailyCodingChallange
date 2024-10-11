import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String[] splitString = st.nextToken().toString().split("[^a-zA-Z0-9]");
            for (String a : splitString) {
                sb.append(a.toLowerCase());
            }
        }
        
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
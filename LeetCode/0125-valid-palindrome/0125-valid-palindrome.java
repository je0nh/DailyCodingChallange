import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int lastIndex = s.length() - 1;
        if (lastIndex <= 0) {
            return true;
        }
        for (int i = 0; i <= (s.length() - 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(lastIndex)) {
                return false;
            }
            lastIndex--;
        }
        return true;
    }
}
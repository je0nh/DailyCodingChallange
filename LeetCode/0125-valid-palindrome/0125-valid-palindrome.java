import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        int frontIdx = 0;
        int rearIdx = s.length() - 1;
        while (frontIdx < rearIdx) {
            char front = s.charAt(frontIdx);
            char rear = s.charAt(rearIdx);

            if (!checkChar(front)) {
                frontIdx++;
                continue;
            }

            if (!checkChar(rear)) {
                rearIdx--;
                continue;
            }

            if (front != rear) {
                return false;
            }

            frontIdx++;
            rearIdx--;
        }
        return true;
    }

    private boolean checkChar(char c) {
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
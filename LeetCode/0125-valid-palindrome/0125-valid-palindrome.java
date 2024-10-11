import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        int frontIdx = 0;
        int rearIdx = s.length() - 1;
        char front, rear;
        while (frontIdx < rearIdx) {
            front = s.charAt(frontIdx);
            rear = s.charAt(rearIdx);

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
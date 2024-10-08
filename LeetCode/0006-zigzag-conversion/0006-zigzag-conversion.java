import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {return s;}

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean down = false;
        
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) {
                down = !down;
            }
            currentRow += down? 1 : -1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            answer.append(rows[i]);
        }

        return answer.toString();
    }
}
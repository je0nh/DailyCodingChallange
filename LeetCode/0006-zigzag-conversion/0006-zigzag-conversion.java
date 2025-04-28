class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int row = 0;
        int sign = -1;
        for (int i = 0; i < s.length(); i++) {
            rows[row] += s.charAt(i);
            if (row == 0 || row == numRows - 1) {
                sign *= -1;
            }
            row += sign;
        }

        String ans = "";
        for (String r : rows) {
            ans += r;
        }
        return ans;
        // PAYPAL ISHIRI NG
    }
}
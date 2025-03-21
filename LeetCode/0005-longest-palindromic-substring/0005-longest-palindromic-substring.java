class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(checkPalindrom(s, i, i), checkPalindrom(s, i, i + 1));

            if (len > end - start) {
                start = i - (len - 1) / 2; // 1 -> len = (4 - 1) / 2
                end = i + (len / 2); // 1 -> len = 4 / 2 = 2
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int checkPalindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; // -1
            right++; // 5
        }
        return right - (left + 1);
    }
}
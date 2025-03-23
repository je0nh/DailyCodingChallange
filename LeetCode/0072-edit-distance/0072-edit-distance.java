class Solution {
    public int minDistance(String word1, String word2) {
        /**  => 빈 문자열이 ros로 변환
         * 교체 ""  r  o  s
         *  ""  0  1  2  3
         *   h  1
         *   o  2
         *   r  3
         *   s  4
         *   e  5
         *  horse가 빈 문자열로 변환
         */
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 마지막 문자가 같으면 이전과 동일 -> {h, r => 1}, {ho, ro => 1}
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 교체, 삭제, 삽입 중 최소 연산 선택
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
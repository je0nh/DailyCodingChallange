class Solution {
    public int maxProfit(int[] prices) {
        int transaction = 2;
        int days = prices.length;
        int[][] dp = new int[transaction + 1][days];
        
        /**    3  3  5  0  0  3  1  4
            0 [0, 0, 0, 0, 0, 0, 0, 0]
            1 [0, 0, 2, 2, 2, 3, 3, 4]
            2 [0, 0, 2, 2, 2, 5, 5, 6]
         */
        for (int i = 1; i <= transaction; i++) {
            int minPrice = prices[0];
            for (int j = 1; j < days; j++) {
                // minPrice = Math.min(minPrice, prices[j]);
                minPrice = Math.min(minPrice, prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - minPrice);
            }
        }

        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }

        return dp[transaction][days - 1];
    }
}
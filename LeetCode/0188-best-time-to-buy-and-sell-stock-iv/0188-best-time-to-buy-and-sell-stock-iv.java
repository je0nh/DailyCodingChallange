class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[][] dp = new int[k + 1][days];
        
        for (int i = 1; i <= k; i++) {
            int minPrice = prices[0];
            for (int j = 1; j < days; j++) {
                minPrice = Math.min(minPrice, prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - minPrice);
            }
        }

        return dp[k][days - 1];
    }
}
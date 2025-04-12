class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        // System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(price > prices[i]) {
                price = prices[i];
                continue;
            }
            sum += prices[i] - price;
            price = prices[i];
            // System.out.println(sum);
        }
        return sum;
    }
}
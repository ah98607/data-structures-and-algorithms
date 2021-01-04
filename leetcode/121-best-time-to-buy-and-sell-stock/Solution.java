class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = Math.min(prices[0], prices[1]);
        int maxProfit = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
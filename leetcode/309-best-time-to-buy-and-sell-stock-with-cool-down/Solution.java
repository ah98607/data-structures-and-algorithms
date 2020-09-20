class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0] - fee);
        for (int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        }
        return sell[sell.length - 1];
    }
}
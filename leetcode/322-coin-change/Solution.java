class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 0; j < coins.length; j++) {
                    int temp = i + coins[j];
                    if (temp > 0 && temp <= amount) {
                        dp[temp] = Math.min(dp[temp], dp[i] + 1);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
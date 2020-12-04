class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 1; i + j * j <= n; j++) {
                    int temp = i + j * j;
                    dp[temp] = Math.min(dp[temp], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}
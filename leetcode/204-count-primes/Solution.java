class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] dp = new boolean[n]; // dp[0-1] not used
        Arrays.fill(dp, true);
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                for (int j = 1; i + j * i < n; j++) {
                    dp[i + j * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                count++;
            }
        }
        return count;
    }
}
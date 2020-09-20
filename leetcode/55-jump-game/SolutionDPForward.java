class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = 0; j <= nums[i] && i + j < nums.length; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
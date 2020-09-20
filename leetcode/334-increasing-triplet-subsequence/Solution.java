class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
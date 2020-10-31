class Solution {
    public boolean canJump(int[] nums) {
        /*
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
        */
        int index = 0;
        int reach = 0;
        while (index < nums.length && index <= reach) {
            reach = Math.max(reach, index + nums[index]);
            index++;
        }
        return index == nums.length;
    }
}
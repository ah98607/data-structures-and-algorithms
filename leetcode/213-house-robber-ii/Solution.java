class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dpA = new int[nums.length];
        int[] dpB = new int[nums.length];
        dpA[0] = nums[0];
        dpA[1] = Math.max(nums[0], nums[1]);
        dpB[0] = 0;
        dpB[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            dpA[i] = Math.max(dpA[i - 1], dpA[i - 2] + nums[i]);
        }
        for (int i = 2; i < nums.length; i++) {
            dpB[i] = Math.max(dpB[i - 1], dpB[i - 2] + nums[i]);
        }
        return Math.max(dpA[nums.length - 2], dpB[nums.length - 1]);
    }
}
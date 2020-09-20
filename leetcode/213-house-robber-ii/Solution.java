class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dpA = new int[nums.length];
        int[] dpB = new int[nums.length];
        dpA[0] = 0;
        dpA[1] = nums[1];
        dpB[0] = nums[0];
        dpB[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dpA[i] = Math.max(dpA[i - 1], nums[i] + dpA[i - 2]);
        }
        for (int i = 2; i < nums.length - 1; i++) {
            dpB[i] = Math.max(dpB[i - 1], nums[i] + dpB[i - 2]);
        }
        return Math.max(dpA[nums.length - 1], dpB[nums.length - 2]);
    }
}
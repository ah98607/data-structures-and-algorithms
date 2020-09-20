class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % k != 0) {
            return false;
        }
        return recFind(0, 0, total / k, k, nums, new boolean[nums.length]);
    }
    private boolean recFind(int start, int sum, int target, int k, int[] nums, boolean[] vis) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return recFind(0, 0, target, k - 1, nums, vis);
        }
        for (int i = start; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (recFind(i + 1, sum + nums[i], target, k, nums, vis)) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
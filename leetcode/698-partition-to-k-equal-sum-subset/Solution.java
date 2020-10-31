class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % k != 0) {
            return false;
        }
        return recFind(0, 0, total / k, nums, k, new boolean[nums.length]);
    }
    private boolean recFind(int start, int sum, int target, int[] nums, int k, boolean[] vis) {
        if (sum >= target) {
            if (sum == target) {
                return recFind(0, 0, target, nums, k - 1, vis);
            }
            return false;
        }
        if (k == 1) {
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (recFind(i + 1, sum + nums[i], target, nums, k, vis)) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % k != 0) {
            return false;
        }
        return recFind(0, 0, total / k, new boolean[nums.length], nums, k);
    }
    private boolean recFind(int start, int sum, int target, boolean[] vis, int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        if (sum >= target) {
            if (sum == target) {
                return recFind(0, 0, target, vis, nums, k - 1);
            }
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (recFind(i + 1, sum + nums[i], target, vis, nums, k)) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 == 1) {
            return false;
        }
        return recFind(0, 2, total / 2, nums, 0, new boolean[nums.length]);
    }
    private boolean recFind(int sum, int k, int target, int[] nums, int start, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return recFind(0, k - 1, target, nums, 0, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (recFind(sum + nums[i], k, target, nums, i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (recFind(i, 0, 0, nums, k)) {
                return true;
            }
        }
        return false;
    }
    private boolean recFind(int start, int len, int sum, int[] nums, int k) {
        if (k == 0 && sum == 0 && len >= 2 || k != 0 && sum % k == 0 && len >= 2) {
            return true;
        }
        if (start == nums.length) {
            return false;
        }
        return recFind(start + 1, len + 1, sum + nums[start], nums, k);
    }
}
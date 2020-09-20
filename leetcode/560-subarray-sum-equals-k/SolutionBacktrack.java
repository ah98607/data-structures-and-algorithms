class Solution {
    int res;
    public int subarraySum(int[] nums, int k) {
        res = 0;
        for (int i = 0; i <= nums.length; i++) {
            recFind(i, 0, 0, nums, k);
        }
        return res;
    }
    private void recFind(int start, int sum, int len, int[] nums, int k) {
        if (sum == k && len > 0) {
            res++;
        }
        if (start == nums.length) {
            return;
        }
        recFind(start + 1, sum + nums[start], len + 1, nums, k);
    }
}
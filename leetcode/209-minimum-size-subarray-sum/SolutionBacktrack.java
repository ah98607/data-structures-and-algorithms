class Solution {
    int minLen;
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            recFind(i, 0, s, nums);
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
    private void recFind(int start, int len, int target, int[] nums) {
        if (target <= 0) {
            minLen = Math.min(minLen, len);
            return;
        }
        if (start == nums.length) {
            return;
        }
        recFind(start + 1, len + 1, target - nums[start], nums);
    }
}
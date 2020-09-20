class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
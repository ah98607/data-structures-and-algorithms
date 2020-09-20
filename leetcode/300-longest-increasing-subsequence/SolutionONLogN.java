class Solution {
    int dpIndex = 0;
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        // initialize
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            insertElement(nums, dp, i);
        }
        return dpIndex + 1;
    }
    // internal private binary search
    private void insertElement(int[] nums, int[] dp, int i) {
        if (nums[i] > dp[dpIndex]) {
            dpIndex++;
            dp[dpIndex] = nums[i];
            return;
        }
        int left = 0;
        int right = dpIndex;
        int mid = 0;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (nums[i] < dp[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (nums[i] <= dp[left]) {
            dp[left] = nums[i];
        }
        else if (nums[i] <= dp[right]) {
            dp[right] = nums[i];
        }
        else {
            dp[right + 1] = nums[i];
        }
        return;
    }
}
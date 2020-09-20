class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > 0) {
                int localSum = sum;
                if (k == 0 && localSum == 0 || k != 0 && localSum % k == 0) {
                    return true;
                }
                for (int j = 0; j < i - 1; j++) {
                    localSum -= nums[j];
                    if (k == 0 && localSum == 0 || k != 0 && localSum % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
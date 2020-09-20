class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res++;
            }
            int localSum = sum;
            for (int j = 0; j < i; j++) {
                localSum -= nums[j];
                if (localSum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
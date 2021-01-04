class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int sum = -1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp < k) {
                left++;
                sum = Math.max(sum, temp);
            }
            else {
                right--;
            }
        }
        return sum;
    }
}
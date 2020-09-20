class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            }
            else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return Math.min(min, Math.min(nums[left], nums[right]));
    }
}
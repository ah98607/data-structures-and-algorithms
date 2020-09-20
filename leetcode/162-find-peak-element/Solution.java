class Solution {
    public int findPeakElement(int[] nums) {
        return recFind(nums, 0, nums.length - 1);
    }
    private int recFind(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return recFind(nums, left, mid - 1);
        }
        if (mid < right && nums[mid] < nums[mid + 1]) {
            return recFind(nums, mid + 1, right);
        }
        return mid;
    }
}
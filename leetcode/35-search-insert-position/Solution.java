class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (target <= nums[left]) {
            return left;
        }
        if (target <= nums[right]) {
            return right;
        }
        return right + 1;
    }
}
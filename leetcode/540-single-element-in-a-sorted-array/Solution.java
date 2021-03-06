class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 1) {
                    left = mid + 1;
                }
                else {
                    right = mid - 2;
                }
            }
            else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 1) {
                    right = mid - 1;
                }
                else {
                    left = mid + 2;
                }
            }
            else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
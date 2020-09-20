class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int rawIndex = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                rawIndex = mid;
                break;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if(rawIndex == -1) {
            return -1;
        }
        else {
            while (rawIndex >=0 && nums[rawIndex] == target) {
                rawIndex--;
            }
            return rawIndex + 1;
        }
    }
}
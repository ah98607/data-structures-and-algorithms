class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return recFind(A, 0, A.length - 1);
    }
    private int recFind(int[] nums, int left, int right) {
        if (left == right - 1) {
            return nums[left] > nums[right] ? left : right;
        }
        int mid = left + (right - left) / 2;
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return recFind(nums, left, mid - 1);
        }
        else if (mid < right && nums[mid] < nums[mid + 1]) {
            return recFind(nums, mid + 1, right);
        }
        return mid;
    }
}
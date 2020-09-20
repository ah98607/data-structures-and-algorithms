class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int pivot = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                pivot = mid;
                break;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (target == nums[left]) {
            pivot = left;
        }
        if (target == nums[right]) {
            pivot = right;
        }
        if (pivot == -1) {
            return res;
        }
        int index = pivot;
        while (index >= 0 && nums[index] == nums[pivot]) {
            index--;
        }
        res[0] = index + 1;
        index = pivot;
        while (index < nums.length && nums[index] == nums[pivot]) {
            index++;
        }
        res[1] = index - 1;
        return res;
    }
}
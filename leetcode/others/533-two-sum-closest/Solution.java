public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                diff = Math.min(diff, target - nums[left] - nums[right]);
                left++;
            }
            else {
                diff = Math.min(diff, nums[left] + nums[right] - target);
                right--;
            }
        }
        return diff;
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int index = 0;
        int right = nums.length - 1;
        while (index < nums.length && index <= right) {
            if (nums[index] == 0) {
                swap(nums, left++, index++);
            }
            else if (nums[index] == 1) {
                index++;
            }
            else {
                swap(nums, index, right--);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
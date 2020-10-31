class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        while (index <= right) {
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
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
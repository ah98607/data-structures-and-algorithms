class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int tempSum = getClosestSum(nums[i], nums, i + 1, nums.length - 1, target);
            if (Math.abs(tempSum - target) < diff) {
                closestSum = tempSum;
                diff = Math.abs(closestSum - target);
            }
        }
        return closestSum;
    }
    private int getClosestSum(int currentNum, int[] nums, int left, int right, int target) {
        int diff = Integer.MAX_VALUE;
        int closestSum = 0;
        while (left < right) {
            int tempSum = currentNum + nums[left] + nums[right];
            if (tempSum == target) {
                return tempSum;
            }
            else if (tempSum < target) {
                left++;
            }
            else {
                right--;
            }
            if (Math.abs(tempSum - target) < diff) {
                closestSum = tempSum;
                diff = Math.abs(tempSum - target);
            }
        }
        return closestSum;
    }
}
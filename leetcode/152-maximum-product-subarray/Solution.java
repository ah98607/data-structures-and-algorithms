class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxPos = new int[nums.length];
        int[] minNeg = new int[nums.length];
        maxPos[0] = nums[0];
        minNeg[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxPos[i] = Math.max(nums[i], maxPos[i - 1] * nums[i]);
                minNeg[i] = minNeg[i - 1] * nums[i];
            }
            else {
                maxPos[i] = minNeg[i - 1] * nums[i];
                minNeg[i] = Math.min(nums[i], maxPos[i - 1] * nums[i]);
            }
            maxProduct = Math.max(maxProduct, maxPos[i]);
        }
        return maxProduct;
    }
}
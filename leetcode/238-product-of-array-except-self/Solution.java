class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftProd[i] = 1;
                rightProd[nums.length - 1 - i] = 1;
            }
            else {
                leftProd[i] = nums[i - 1] * leftProd[i - 1];
                rightProd[nums.length - 1 - i] = nums[nums.length - i] * rightProd[nums.length - i];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }
}
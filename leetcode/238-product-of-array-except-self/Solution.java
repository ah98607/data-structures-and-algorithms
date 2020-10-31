class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] lProd = new int[nums.length];
        int[] rProd = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lProd[i] = 1;
                rProd[nums.length - 1 - i] = 1;
            }
            else {
                lProd[i] = lProd[i - 1] * nums[i - 1];
                rProd[nums.length - 1 - i] = rProd[nums.length - i] * nums[nums.length - i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = lProd[i] * rProd[i];
        }
        return res;
    }
}
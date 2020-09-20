class Solution {
    public int missingNumber(int[] nums) {
        int exp = nums.length * (nums.length + 1) / 2;
        int act = 0;
        for (int i = 0; i < nums.length; i++) {
            act += nums[i];
        }
        return exp - act;
    }
}
class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = i == 0 ? nums[i] : nums[i] + preSum[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? preSum[j] : preSum[j] - preSum[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
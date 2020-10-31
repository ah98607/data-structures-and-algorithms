class Solution {
    int[] ori;
    int[] cp;
    Random r;
    public Solution(int[] nums) {
        ori = nums;
        cp = reset();
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] nums = new int[ori.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ori[i];
        }
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < cp.length; i++) {
            swap(cp, i, r.nextInt(cp.length));
        }
        return cp;
    }
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
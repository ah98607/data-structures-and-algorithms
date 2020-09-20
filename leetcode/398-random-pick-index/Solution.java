class Solution {
    
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                Random r = new Random();
                int randomIndex = r.nextInt(count);
                if (randomIndex % count == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
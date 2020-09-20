class Solution {
    public int jump(int[] nums) {
        int reach = 0;
        int index = 0;
        int[] prev = new int[nums.length];
        while (index < nums.length) {
            if (index + nums[index] > reach) {
                for (int i = reach + 1; i < nums.length && i <= index + nums[index]; i++) {
                    prev[i] = index;
                }
                reach = index + nums[index];
            }
            index++;
        }
        int steps = 0;
        int pos = nums.length - 1;
        while (pos > 0) {
            pos = prev[pos];
            steps++;
        }
        return steps;
    }
}
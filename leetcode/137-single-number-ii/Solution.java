class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += ((nums[j] >> i) & 1);
            }
            res |= (temp % 3) << i;
        }
        return res;
    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int indexOfBitOne = 0;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) {
                indexOfBitOne = i;
                break;
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> indexOfBitOne) & 1) == 1) {
                res[0] ^= nums[i];
            }
            else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
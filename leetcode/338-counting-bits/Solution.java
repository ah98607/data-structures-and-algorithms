class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1]; // 0, 1, 2, n
        if (num == 0) {
            result[0] = 0;
            return result;
        }
        result[0] = 0;
        int nextPowOfTwo = 1; // 2^0;
        int prev = -1;
        for (int i = 1; i < num + 1; i++) {
            if (i == nextPowOfTwo) {
                result[i] = 1;
                prev = 1;
                nextPowOfTwo = (i << 1);
            }
            else {
                result[i] = result[prev] + 1;
                prev++;
            }
        }
        return result;
    }
}
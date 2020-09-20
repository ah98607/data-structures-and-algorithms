class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            int z = n / 5;
            result += z;
            n = z;
        }
        return result;
    }
}
class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, n / 3);
        }
        if (mod == 1) {
            return (int) Math.pow(3, (n - 4) / 3) * 4;
        }
        return (int) Math.pow(3, (n - 2) / 3) * 2;
    }
}
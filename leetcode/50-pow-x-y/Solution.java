class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = Math.pow(x, n / 2);
        if ((n & 1) == 0) {
            return half * half;
        }
        if (n > 0) {
            return half * half * x;
        }
        return half * half / x;
    }
}
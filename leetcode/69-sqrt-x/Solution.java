class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = (int) Math.sqrt(Integer.MAX_VALUE);
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int temp = mid * mid;
            if (temp == x) {
                return mid;
            }
            if (temp < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (x < left * left) {
            return left - 1;
        }
        if (x < right * right) {
            return right - 1;
        }
        return right;
    }
}
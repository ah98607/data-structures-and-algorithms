class Solution {
    public boolean isPerfectSquare(int num) {
        int lsd = num % 10;
        if (lsd == 2 || lsd == 3 || lsd == 7 || lsd == 8) {
            return false;
        }
        int left = 1;
        int right = (int) Math.sqrt(Integer.MAX_VALUE);
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int temp = mid * mid;
            if (num == temp) {
                return true;
            }
            if (num < temp) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return num == left * left || num == right * right;
    }
}
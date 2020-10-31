class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }
    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            int temp = res * 10 + n % 10;
            if (temp / 10 != res) {
                return 0;
            }
            res = temp;
            n /= 10;
        }
        return res;
    }
}
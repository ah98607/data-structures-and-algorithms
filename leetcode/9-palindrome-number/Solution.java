class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }
    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            int temp = res * 10 + x % 10;
            if (temp / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }
}
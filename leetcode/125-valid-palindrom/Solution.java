class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (!alphabetic(s.charAt(left))) {
                left++;
            }
            else if (!alphabetic(s.charAt(right))) {
                right--;
            }
            else if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    private boolean alphabetic(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}
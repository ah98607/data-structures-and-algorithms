class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        int diff = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else {
                diff++;
                if (diff > 1) {
                    return false;
                }
                if (right - left < 2 || s.charAt(left + 1) == s.charAt(right) && s.charAt(left + 2) == s.charAt(right - 1)) {
                    left++;
                }
                else if (right - left < 2 || s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) == s.charAt(right - 2)) {
                    right--;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
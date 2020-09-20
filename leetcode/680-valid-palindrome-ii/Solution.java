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
                if (diff == 2) {
                    return false;
                }
                if (s.charAt(left + 1) == s.charAt(right) && (right - left <= 2 || s.charAt(left + 2) == s.charAt(right - 1))) {
                    left++;
                }
                else if (s.charAt(left) == s.charAt(right - 1) && (right - left <= 2 || s.charAt(left + 1) == s.charAt(right - 2))) {
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
class Solution {
    public String reverseOnlyLetters(String S) {
        if (S.length() == 0) {
            return new String();
        }
        int left = 0;
        int right = S.length() - 1;
        char[] cArray = S.toCharArray();
        while (left < right) {
            while (left < right && !isLetter(cArray[left])) {
                left++;
            }
            while (left < right && !isLetter(cArray[right])) {
                right--;
            }
            if (cArray[left] != cArray[right]) {
                swap(cArray, left, right);
            }
            left++;
            right--;
        }
        return new String(cArray);
    }
    private boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
    private void swap(char[] cArray, int left, int right) {
        char temp = cArray[left];
        cArray[left] = cArray[right];
        cArray[right] = temp;
    }
}
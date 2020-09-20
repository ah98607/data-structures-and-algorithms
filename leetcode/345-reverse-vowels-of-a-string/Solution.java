class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] cArray = s.toCharArray();
        int left = 0;
        int right = cArray.length - 1;
        while (left < right) {
            if (!isVowel(s.charAt(left))) {
                left++;
            }
            else if (!isVowel(s.charAt(right))) {
                right--;
            }
            else {
                swap(cArray, left, right);
                left++;
                right--;
            }
        }
        return new String(cArray);
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    private void swap(char[] cArray, int left, int right) {
        char temp = cArray[left];
        cArray[left] = cArray[right];
        cArray[right] = temp;
    }
}
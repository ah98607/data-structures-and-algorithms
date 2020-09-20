class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] cArray = s.toCharArray();
        int start = 0;
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] == ' ') {
                reverse(cArray, start, i - 1);
                start = i + 1;
            }
        }
        reverse(cArray, start, cArray.length - 1);
        return new String(cArray);
    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
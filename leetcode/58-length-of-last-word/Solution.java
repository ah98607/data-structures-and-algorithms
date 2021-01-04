class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i != start) {
                    len = i - start;
                }
                start = i + 1;
            }
        }
        if (s.length() != start) {
            len = s.length() - start;
        }
        return len;
    }
}
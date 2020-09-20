class Solution {
    int res;
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        res = 0;
        recFind(0, s);
        return res;
    }
    private void recFind(int start, String s) {
        if (start == s.length()) {
            res++;
            return;
        }
        for (int i = start; i < s.length() && i < start + 2; i++) {
            if (isValid(s.substring(start, i + 1))) {
                recFind(i + 1, s);
            }
            else {
                return;
            }
        }
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }
}
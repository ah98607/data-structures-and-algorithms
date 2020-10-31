class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] prevAppear = new int[26];
        Arrays.fill(prevAppear, -1);
        int start = 0;
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (prevAppear[S.charAt(i) - 'a'] != -1) {
                start = Math.max(start, prevAppear[S.charAt(i) - 'a'] + 1);
            }
            if (i - start + 1 >= K) {
                res++;
            }
            prevAppear[S.charAt(i) - 'a'] = i;
        }
        return res;
    }
}
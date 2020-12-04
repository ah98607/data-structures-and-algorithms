class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();
        int[] lastAppear = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastAppear[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastAppear[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
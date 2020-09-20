class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] finalAppear = new int[26];
        Arrays.fill(finalAppear, -1);
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            finalAppear[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, finalAppear[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
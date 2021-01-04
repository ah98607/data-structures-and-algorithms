class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }
        int[] bin = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bin[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 1; i < bin.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((bin[j] & bin[i]) == 0) {
                    res = Math.max(res, words[j].length() * words[i].length());
                }
            }
        }
        return res;
    }
}
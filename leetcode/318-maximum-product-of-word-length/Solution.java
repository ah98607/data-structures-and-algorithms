class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }
        int[] bin = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bin[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        int maxProd = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((bin[i] & bin[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2 || order.length() < 2) {
            return true;
        }
        int[] od = new int[26];
        Arrays.fill(od, -1);
        for (int i = 0; i < order.length(); i++) {
            od[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j++) {
                if (words[i].charAt(j) != words[i - 1].charAt(j)) {
                    if (od[words[i].charAt(j) - 'a'] != -1 && od[words[i - 1].charAt(j) - 'a'] != -1 && od[words[i].charAt(j) - 'a'] < od[words[i - 1].charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
                if (j == words[i].length() - 1 && j < words[i - 1].length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
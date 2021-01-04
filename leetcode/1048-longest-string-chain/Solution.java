class Solution {
    public int longestStrChain(String[] words) {
        if (words.length < 2) {
            return words.length;
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (successor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    private boolean successor(String s1, String s2) {
        if (s1.length() == s2.length() + 1) {
            for (int i = 0; i < s1.length(); i++) {
                if (s2.equals(s1.substring(0, i) + s1.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
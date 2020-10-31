class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        int maxLen = 1;
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (predecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    private boolean predecessor(String s1, String s2) {
        if (s1.length() != s2.length() - 1) {
            return false;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s1.equals(s2.substring(0, i) + s2.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
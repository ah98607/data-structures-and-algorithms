public class Solution {
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(s + ": " + lsa(s));
        s = "baaabbabbb";
        System.out.println(s + ": " + lsa(s));
        s = "abaaaa";
        System.out.println(s + ": " + lsa(s));
    }
    public static int lsa(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        int start = 0;
        int maxLen = 0;
        while (index < s.length()) {
            if (index >= 2 && s.charAt(index) == s.charAt(index - 1) && s.charAt(index - 1) == s.charAt(index - 2)) {
                int len = index - 1 - start + 1;
                maxLen = Math.max(maxLen, len);
                start = index - 1;
            }
            index++;
        }
        maxLen = Math.max(maxLen, s.length() - start);
        return maxLen;
    }
}
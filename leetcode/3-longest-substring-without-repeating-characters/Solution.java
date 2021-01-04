class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> prevAppear = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (prevAppear.containsKey(s.charAt(i))) {
                start = Math.max(start, prevAppear.get(s.charAt(i)) + 1);
            }
            maxLen = Math.max(maxLen, i - start + 1);
            prevAppear.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!freq.containsKey(s.charAt(i))) {
                freq.put(s.charAt(i), 1);
            }
            else {
                freq.put(s.charAt(i), 1 + freq.get(s.charAt(i)));
            }
            while (freq.size() > k) {
                freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
                if (freq.get(s.charAt(start)) == 0) {
                    freq.remove(s.charAt(start));
                }
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
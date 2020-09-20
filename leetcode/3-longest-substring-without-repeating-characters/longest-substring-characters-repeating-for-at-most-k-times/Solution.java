class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        Map<Character, Queue<Integer>> prevAppear = new HashMap<Character, Queue<Integer>>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (prevAppear.containsKey(s.charAt(i))) {
                if (prevAppear.get(s.charAt(i)).size() == k) {
                    start = Math.max(start, prevAppear.get(s.charAt(i)).peek() + 1);
                    prevAppear.get(s.charAt(i)).poll();
                }
            }
            else {
                prevAppear.put(s.charAt(i), new LinkedList());
            }
            maxLen = Math.max(maxLen, i - start + 1);
            prevAppear.get(s.charAt(i)).offer(i);
        }
        return maxLen;
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!s2t.containsKey(s.charAt(i))) {
                s2t.put(s.charAt(i), t.charAt(i));
            }
            else if (s2t.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (!t2s.containsKey(t.charAt(i))) {
                t2s.put(t.charAt(i), s.charAt(i));
            }
            else if (t2s.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                }
            }
            return diff == 1;
        }
        if (s.length() == t.length() + 1) {
            for (int i = 0; i < s.length(); i++) {
                if (t.equals(s.substring(0, i) + s.substring(i + 1))) {
                    return true;
                }
            }
            return false;
        }
        if (t.length() == s.length() + 1) {
            for (int i = 0; i < t.length(); i++) {
                if (s.equals(t.substring(0, i) + t.substring(i + 1))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
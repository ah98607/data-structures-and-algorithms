class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) {
            return false;
        }
        Map<Character, String> c2s = new HashMap<Character, String>();
        Map<String, Character> s2c = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!c2s.containsKey(pattern.charAt(i))) {
                c2s.put(pattern.charAt(i), sArray[i]);
            }
            else if (!c2s.get(pattern.charAt(i)).equals(sArray[i])) {
                return false;
            }
            if (!s2c.containsKey(sArray[i])) {
                s2c.put(sArray[i], pattern.charAt(i));
            }
            else if (s2c.get(sArray[i]) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
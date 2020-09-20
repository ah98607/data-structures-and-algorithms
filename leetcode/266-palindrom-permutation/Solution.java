class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
            else {
                set.add(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }
}
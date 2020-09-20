class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeats = 1;
        String cp = a;
        while (cp.length() < b.length()) {
            cp += a;
            repeats++;
        }
        if (cp.indexOf(b) >= 0) {
            return repeats;
        }
        for (int i = 0; i < 2; i++) {
            cp += a;
            repeats++;
            if (cp.indexOf(b) >= 0) {
                return repeats;
            }
        }
        return -1;
    }
}
class Solution {
    public int repeatedStringMatch(String a, String b) {
        String cp = a;
        int repeats = 1;
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
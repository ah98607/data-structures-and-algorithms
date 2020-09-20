class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.substring(i, i + 1)) != -1) {
                count++;
            }
        }
        return count++;
    }
}
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            if (mod == 0) {
                sb.append("Z");
                n = n / 26 - 1;
            }
            else {
                sb.append((char) ('A' + mod - 1));
                n /= 26;
            }
        }
        return sb.reverse().toString();
    }
}
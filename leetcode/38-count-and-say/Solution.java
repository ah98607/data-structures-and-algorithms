public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        char[] cArray = String.valueOf(n).toCharArray();
        if (cArray.length == 1) {
            sb.append(1);
            sb.append(cArray[0]);
        }
        char prev = 'x';
        int count = 1;
        for (int i = 0; i < cArray.length; i++) {
            if (i == 0) {
                prev = cArray[0];
            }
            else if (i == cArray.length - 1) {
                if (cArray[i] == prev) {
                    count++;
                    sb.append(count);
                    sb.append(prev);
                }
                else {
                    sb.append(count);
                    sb.append(prev);
                    sb.append("1");
                    sb.append(cArray[i]);
                }
            }
            else {
                if (cArray[i] == prev) {
                    count++;
                }
                else {
                    sb.append(count);
                    sb.append(prev);
                    prev = cArray[i];
                    count = 1;
                }
            }
        }
        return sb.toString();
    }
}
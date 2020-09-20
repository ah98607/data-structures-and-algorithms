public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0) {
            return false;
        }
        int length = num.length();
        for(int i = 1; i <= length / 2; i++) {
            for(int j = 1; Math.max(i, j) <= length - i - j; j++) {
                if(isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(String num, int x, int y) {
        // don't allow num = "0123"
        if(num.charAt(0) == '0' && x > 1) {
            return false;
        }
        // don't allow num = "11 02"
        if(num.charAt(x) == '0' && y > 1) {
            return false;
        }
        Long num1 = Long.parseLong(num.substring(0, x)); // read char 0 .. char x - 1
        Long num2 = Long.parseLong(num.substring(x, x + y));
        
        String sum;
        // search for a match
        for(int k = x + y; k < num.length(); k += sum.length()) {
            num2 = num1 + num2;
            num1 = num2 - num1;
            sum = num2.toString();
            if(!num.startsWith(sum, k)) {
                return false;
            }
        }
        return true;
    }
}
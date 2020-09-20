class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        System.out.println(str);
        int index = 0;
        boolean negative = false;
        if (str.charAt(0) == '-') {
            index = 1;
            negative = true;
        }
        if (str.charAt(0) == '+') {
            index = 1;
            negative = false;
        }
        int result = 0;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            int temp = result * 10 + (int) (str.charAt(index) - '0');
            if (temp / 10 != result) {
                if (negative) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            else {
                result = temp;
            }
            index++;
        }
        if (negative) {
            return -result;
        }
        else {
            return result;
        }
        
    }
}
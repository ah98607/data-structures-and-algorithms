class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int cout = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int temp = num1.charAt(index1--) - '0' + num2.charAt(index2--) - '0' + cout;
            sb.append(String.valueOf(temp % 10));
            cout = temp / 10;
        }
        while (index1 >= 0) {
            int temp = num1.charAt(index1--) - '0' + cout;
            sb.append(String.valueOf(temp % 10));
            cout = temp / 10;
        }
        while (index2 >= 0) {
            int temp = num2.charAt(index2--) - '0' + cout;
            sb.append(String.valueOf(temp % 10));
            cout = temp / 10;
        }
        if (cout == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
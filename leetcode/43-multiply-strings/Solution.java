class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] product = new int[num1.length() + num2.length()];
        Arrays.fill(product, 0);
        int cout = 0;
        for (int i = 0; i < num2.length(); i++) {
            for (int j = 0; j < num1.length(); j++) {
                int temp = product[i + j] + (num1.charAt(num1.length() - 1 - j) - 48) * (num2.charAt(num2.length() - 1 - i) - 48) + cout;
                product[j + i] = temp % 10;
                cout = temp / 10;
            }
            if (cout != 0) {
                product[num1.length() + i] = cout;
                cout = 0;
            }
        }
        /*for (int i = 0; i < product.length; i++) {
            System.out.print(product[i] + " ");
        }*/
        boolean isZero = true;
        StringBuilder sb = new StringBuilder();
        for (int i = product.length - 1; i >= 0; i--) {
            if (!isZero) {
                sb.append(product[i]);
            }
            else {
                if (product[i] != 0) {
                    isZero = false;
                    sb.append(product[i]);
                }
            }
        }
        return isZero ? "0" : sb.toString();
    }
}
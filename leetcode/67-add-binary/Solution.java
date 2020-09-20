class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int cout = 0;
        while (indexA >= 0 && indexB >= 0) {
            char bitA = a.charAt(indexA--);
            char bitB = b.charAt(indexB--);
            if (cout == 0) {
                if (bitA == '0' && bitB == '0') {
                    sb.insert(0, 0);
                }
                else if (bitA == '1' && bitB == '1') {
                    sb.insert(0, 0);
                    cout = 1;
                }
                else {
                    sb.insert(0, 1);
                }
            }
            else {
                if (bitA == '0' && bitB == '0') {
                    sb.insert(0, 1);
                    cout = 0;
                }
                else if (bitA == '1' && bitB == '1') {
                    sb.insert(0, 1);
                }
                else {
                    sb.insert(0, 0);
                }
            }
        }
        while (indexA >= 0) {
            char bitA = a.charAt(indexA--);
            if (cout == 0) {
                if (bitA == '0') {
                    sb.insert(0, 0);
                }
                else {
                    sb.insert(0, 1);
                }
            }
            else {
                if (bitA == '0') {
                    sb.insert(0, 1);
                    cout = 0;
                }
                else {
                    sb.insert(0, 0);
                }
            }
        }
        while (indexB >= 0) {
            char bitB = b.charAt(indexB--);
            if (cout == 0) {
                if (bitB == '0') {
                    sb.insert(0, 0);
                }
                else {
                    sb.insert(0, 1);
                }
            }
            else {
                if (bitB == '0') {
                    sb.insert(0, 1);
                    cout = 0;
                }
                else {
                    sb.insert(0, 0);
                }
            }
        }
        if (cout == 1) {
            sb.insert(0, 1);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
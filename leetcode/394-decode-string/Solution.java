class Solution {
    public String decodeString(String s) {
        if (s.indexOf("[") < 0) {
            return s;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int count = s.charAt(index++) - '0';
                while (s.charAt(index) != '[') {
                    count = count * 10 + s.charAt(index++) - '0';
                }
                index++;
                int start = index;
                int brackets = 1;
                while (brackets > 0) {
                    if (s.charAt(index) == '[') {
                        brackets++;
                    }
                    else if (s.charAt(index) == ']') {
                        brackets--;
                    }
                    index++;
                }
                String temp = decodeString(s.substring(start, index - 1));
                for (int i = 0; i < count; i++) {
                    sb.append(temp);
                }
            }
            else {
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }
}
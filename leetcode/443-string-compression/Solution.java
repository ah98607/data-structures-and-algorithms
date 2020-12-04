class Solution {
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int index = 0;
        int start = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                chars[index++] = chars[start];
                String count = String.valueOf(i - start);
                if (!count.equals("1")) {
                    for (int j = 0; j < count.length(); j++) {
                        chars[index++] = count.charAt(j);
                    }
                }
                start = i;
            }
        }
        chars[index++] = chars[start];
        String count = String.valueOf(chars.length - start);
        if (!count.equals("1")) {
            for (int j = 0; j < count.length(); j++) {
                chars[index++] = count.charAt(j);
            }
        }
        return index;
    }
}
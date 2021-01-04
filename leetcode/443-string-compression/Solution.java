class Solution {
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int start = 0;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[start]) {
                String count = String.valueOf(i - start);
                chars[index++] = chars[start];
                if (!count.equals("1")) {
                    for (int j = 0; j < count.length(); j++) {
                        chars[index++] = count.charAt(j);
                    }
                }
                start = i;
            }
        }
        String count = String.valueOf(chars.length - start);
        chars[index++] = chars[start];
        if (!count.equals("1")) {
            for (int j = 0; j < count.length(); j++) {
                chars[index++] = count.charAt(j);
            }
        }
        return index;
    }
}
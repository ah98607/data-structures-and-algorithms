class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] c2i = new int[26];
        c2i['I' - 'A'] = 1;
        c2i['V' - 'A'] = 5;
        c2i['X' - 'A'] = 10;
        c2i['L' - 'A'] = 50;
        c2i['C' - 'A'] = 100;
        c2i['D' - 'A'] = 500;
        c2i['M' - 'A'] = 1000;
        char[] cArray = s.toCharArray();
        int sum = c2i[cArray[0] - 'A'];
        for (int i = 0; i < cArray.length - 1; i++) {
            if (c2i[cArray[i] - 'A'] >= c2i[cArray[i + 1] - 'A']) {
                sum += c2i[cArray[i + 1] - 'A'];
            }
            else {  
                sum += c2i[cArray[i + 1] - 'A'] - 2 * c2i[cArray[i] - 'A'];
            }
        }
        return sum;
    }
}
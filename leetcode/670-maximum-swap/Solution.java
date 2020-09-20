class Solution {
    public int maximumSwap(int num) {
        char[] cArray = String.valueOf(num).toCharArray();
        int[] loc = new int[10];
        for (int i = 0; i < cArray.length; i++) {
            loc[cArray[i] - '0'] = i;
        }
        for (int i = 0; i < cArray.length; i++) {
            for (int j = 9; j > cArray[i] - '0'; j--) {
                int index = loc[j];
                if (index > i) {
                    char temp = cArray[i];
                    cArray[i] = cArray[index];
                    cArray[index] = temp;
                    return Integer.parseInt(new String(cArray));
                }
            }
        }
        return num;
    }
}
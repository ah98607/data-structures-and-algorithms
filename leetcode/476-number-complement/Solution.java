class Solution {
    public int findComplement(int num) {
        int result = 0;
        boolean firstNonZeroFound = false;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                firstNonZeroFound = true;
            }
            else if (firstNonZeroFound) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
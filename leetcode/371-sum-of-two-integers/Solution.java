class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int cout = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            sum |= (bitA ^ bitB ^ cout) << i;
            cout = bitA & bitB | bitA & cout | bitB & cout;
        }
        return sum;
    }
}
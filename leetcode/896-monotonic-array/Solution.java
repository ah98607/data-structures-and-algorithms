class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length < 3) {
            return true;
        }
        int inc = 0; // 1: inc, -1: dec
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (inc == -1) {
                    return false;
                }
                inc = 1;
            }
            else if (A[i] < A[i - 1]) {
                if (inc == 1) {
                    return false;
                }
                inc = -1;
            }
        }
        return true;
    }
}
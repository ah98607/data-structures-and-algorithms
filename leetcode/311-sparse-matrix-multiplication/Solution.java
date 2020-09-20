class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < B[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    // multiplication take a lot of time, so this simple if condition actually saves a lot of time
                    if (A[j][k] != 0 && B[k][i] != 0) {
                        result[j][i] += A[j][k] * B[k][i];
                    }
                }
            }
        }
        return result;
    }
}
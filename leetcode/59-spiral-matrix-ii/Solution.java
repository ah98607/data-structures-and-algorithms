class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loops = n / 2;
        int index = 1;
        for (int i = 0; i < loops; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                res[i][j] = index++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[j][n - 1 - i] = index++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[n - 1 - i][n - 1 - j] = index++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[n - 1 - j][i] = index++;
            }
        }
        if ((n & 1) == 1) {
            res[loops][loops] = index++;
        }
        return res;
    }
}
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loops = n / 2;
        int num = 1;
        for (int i = 0; i < loops; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                res[i][j] = num++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[j][n - 1 - i] = num++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[n - 1 - i][n - 1 - j] = num++;
            }
            for (int j = i; j < n - 1 - i; j++) {
                res[n - 1 - j][i] = num++;
            }
        }
        if ((n & 1) == 1) {
            res[loops][loops] = num;
        }
        return res;
    }
}
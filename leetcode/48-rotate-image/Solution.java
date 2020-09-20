class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int loops = matrix.length / 2;
        for (int i = 0; i < loops; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
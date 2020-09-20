class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int xLen = matrix[0].length;
        int yLen = matrix.length;
        int numIterations = Math.min(xLen, yLen) / 2;
        for (int i = 0; i < numIterations; i++) {
            // top
            for (int j = i; j < xLen - 1 - i; j++) {
                result.add(matrix[i][j]);
            }
            // right
            for (int j = i; j < yLen - 1 - i; j++) {
                result.add(matrix[j][xLen - 1 - i]);
            }
            // bottom
            for (int j = i; j < xLen - 1 - i; j++) {
                result.add(matrix[yLen - 1 - i][xLen - 1 - j]);
            }
            // left
            for (int j = i; j < yLen - 1 - i; j++) {
                result.add(matrix[yLen - 1 - j][i]);
            }
        }
        // deal with central ones
        if (xLen == yLen && xLen % 2 == 1) {
            result.add(matrix[yLen / 2][xLen / 2]);
        }
        else if (xLen > yLen && yLen % 2 == 1) {
            for (int i = yLen / 2; i < xLen - yLen / 2; i++) {
                result.add(matrix[yLen / 2][i]);
            }
        }
        else if (xLen < yLen && xLen % 2 == 1) {
            for (int i = xLen / 2; i < yLen - xLen / 2; i++) {
                result.add(matrix[i][xLen / 2]);
            }
        }
        return result;
    }
}
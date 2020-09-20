class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
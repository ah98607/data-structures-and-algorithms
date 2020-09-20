class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minutes = 0;
        while (true) {
            boolean neighborChanged = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2 && !visited[i][j]) {
                        visited[i][j] = true;
                        changeNeighborsToTemp(grid, i, j);
                    }
                }
            }
            neighborChanged = finalizeTempChanges(grid);
            if (!neighborChanged) {
                break;
            }
            minutes++;
        }
        if (allRotten(grid)) {
            return minutes;
        }
        return -1;
    }
    private void changeNeighborsToTemp(int[][] grid, int row, int col) {
        if (row > 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 3;
        }
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 3;
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 3;
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 3;
        }
    }
    private boolean finalizeTempChanges(int[][] grid) {
        boolean neighborChanged = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 3) {
                    neighborChanged = true;
                    grid[i][j] = 2;
                }
            }
        }
        return neighborChanged;
    }
    private boolean allRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
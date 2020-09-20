class Solution {
    int res;
    public int uniquePathsIII(int[][] grid) {
        int totalSteps = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    totalSteps++;
                }
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        recFind(grid, startRow, startCol, 0, totalSteps, new boolean[grid.length][grid[0].length]);
        return res;
    }
    private void recFind(int[][] grid, int row, int col, int steps, int totalSteps, boolean[][] vis) {
        vis[row][col] = true;
        if (steps == totalSteps) {
            if (row > 0 && grid[row - 1][col] == 2) {
                res++;
            }
            if (row < grid.length - 1 && grid[row + 1][col] == 2) {
                res++;
            }
            if (col > 0 && grid[row][col - 1] == 2) {
                res++;
            }
            if (col < grid[0].length - 1 && grid[row][col + 1] == 2) {
                res++;
            }
        }
        else {
            if (row > 0 && grid[row - 1][col] == 0 && !vis[row - 1][col]) {
                recFind(grid, row - 1, col, steps + 1, totalSteps, vis);
            }
            if (row < grid.length - 1 && grid[row + 1][col] == 0 && !vis[row + 1][col]) {
                recFind(grid, row + 1, col, steps + 1, totalSteps, vis);
            }
            if (col > 0 && grid[row][col - 1] == 0 && !vis[row][col - 1]) {
                recFind(grid, row, col - 1, steps + 1, totalSteps, vis);
            }
            if (col < grid[0].length - 1 && grid[row][col + 1] == 0 && !vis[row][col + 1]) {
                recFind(grid, row, col + 1, steps + 1, totalSteps, vis);
            }
        }
        vis[row][col] = false;
    }
}
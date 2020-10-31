class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, recFind(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    private int recFind(int[][] grid, int row, int col) {
        int area = 1;
        grid[row][col] = 0;
        if (row > 0 && grid[row - 1][col] == 1) {
            area += recFind(grid, row - 1, col);
        }
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            area += recFind(grid, row + 1, col);
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            area += recFind(grid, row, col - 1);
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            area += recFind(grid, row, col + 1);
        }
        return area;
    }
}
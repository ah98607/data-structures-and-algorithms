class Solution {
    public int islandPerimeter(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        c++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        c++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        c++;
                    }
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
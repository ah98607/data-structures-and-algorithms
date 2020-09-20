class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> islands = new HashSet<String>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    recFind(sb, i, j, i, j, grid);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    private void recFind(StringBuilder sb, int row, int col, int baseRow, int baseCol, int[][] grid) {
        grid[row][col] = 0;
        sb.append((row - baseRow) + "" + (col - baseCol));
        if (row > 0 && grid[row - 1][col] == 1) {
            recFind(sb, row - 1, col, baseRow, baseCol, grid);
        }
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            recFind(sb, row + 1, col, baseRow, baseCol, grid);
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            recFind(sb, row, col - 1, baseRow, baseCol, grid);
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            recFind(sb, row, col + 1, baseRow, baseCol, grid);
        }
    }
}
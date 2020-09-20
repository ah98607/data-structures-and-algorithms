class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbors = getLiveNeighbors(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
                else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    private int getLiveNeighbors(int[][] nums, int row, int col) {
        int liveNeighbors = 0;
        if (row > 0 && (nums[row - 1][col] & 1) == 1) {
            liveNeighbors++;
        }
        if (row > 0 && col > 0 && (nums[row - 1][col - 1] & 1) == 1) {
            liveNeighbors++;
        }
        if (col > 0 && (nums[row][col - 1] & 1) == 1) {
            liveNeighbors++;
        }
        if (row < nums.length - 1 && col > 0 && (nums[row + 1][col - 1] & 1) == 1) {
            liveNeighbors++;
        }
        if (row < nums.length - 1 && (nums[row + 1][col] & 1) == 1) {
            liveNeighbors++;
        }
        if (row < nums.length - 1 && col < nums[0].length - 1 && (nums[row + 1][col + 1] & 1) == 1) {
            liveNeighbors++;
        }
        if (col < nums[0].length - 1 && (nums[row][col + 1] & 1) == 1) {
            liveNeighbors++;
        }
        if (row > 0 && col < nums[0].length - 1 && (nums[row - 1][col + 1] & 1) == 1) {
            liveNeighbors++;
        }
        return liveNeighbors;
    }
}
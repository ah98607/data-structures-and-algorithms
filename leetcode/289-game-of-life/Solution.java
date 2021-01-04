class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = getLives(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (lives == 2 || lives == 3) {
                        board[i][j] |= 2;
                    }
                }
                else {
                    if (lives == 3) {
                        board[i][j] |= 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private int getLives(int[][] board, int row, int col) {
        int lives = 0;
        if (row > 0 && (board[row - 1][col] & 1) == 1) {
            lives++;
        }
        if (row > 0 && col < board[0].length - 1 && (board[row - 1][col + 1] & 1) == 1) {
            lives++;
        }
        if (col < board[0].length - 1 && (board[row][col + 1] & 1) == 1) {
            lives++;
        }
        if (row < board.length - 1 && col < board[0].length - 1 && (board[row + 1][col + 1] & 1) == 1) {
            lives++;
        }
        if (row < board.length - 1 && (board[row + 1][col]& 1) == 1) {
            lives++;
        }
        if (row < board.length - 1 && col > 0 && (board[row + 1][col - 1] & 1) == 1) {
            lives++;
        }
        if (col > 0 && (board[row][col - 1] & 1) == 1) {
            lives++;
        }
        if (row > 0 && col > 0 && (board[row - 1][col - 1] & 1) == 1) {
            lives++;
        }
        return lives;
    }
}
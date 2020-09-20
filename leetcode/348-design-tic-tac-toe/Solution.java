class TicTacToe {
    
    int[][] board;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return checkWin();
    }
    private int checkWin() {
        int player = 0;
        for (int i = 0; i < n; i++) {
            player = board[i][0];
            if (player == 1 || player == 2) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != player) {
                        break;
                    }
                    if (j == n - 1 && board[i][j] == player) {
                        return player;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            player = board[0][i];
            if (player == 1 || player == 2) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] != player) {
                        break;
                    }
                    if (j == n - 1 && board[j][i] == player) {
                        return player;
                    }
                }
            }
        }
        player = board[0][0];
        if (player == 1 || player == 2) {
            for (int i = 1; i < n; i++) {
                if (board[i][i] != player) {
                    break;
                }
                if (i == n - 1 && board[i][i] == player) {
                    return player;
                }
            }
        }
        player = board[0][n - 1];
        if (player == 1 || player == 2) {
            for (int i = 1; i < n; i++) {
                if (board[i][n - 1 - i] != player) {
                    break;
                }
                if (i == n - 1 && board[i][n - 1 - i] == player) {
                    return player;
                }
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
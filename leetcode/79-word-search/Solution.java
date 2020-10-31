class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recFind(i, j, board, word.substring(1), vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean recFind(int row, int col, char[][] board, String s, boolean[][] vis) {
        if (s.length() == 0) {
            return true;
        }
        vis[row][col] = true;
        if (row > 0 && board[row - 1][col] == s.charAt(0) && !vis[row - 1][col]) {
            if (recFind(row - 1, col, board, s.substring(1), vis)) {
                return true;
            }
        }
        if (row < board.length - 1 && board[row + 1][col] == s.charAt(0) && !vis[row + 1][col]) {
            if (recFind(row + 1, col, board, s.substring(1), vis)) {
                return true;
            }
        }
        if (col > 0 && board[row][col - 1] == s.charAt(0) && !vis[row][col - 1]) {
            if (recFind(row, col - 1, board, s.substring(1), vis)) {
                return true;
            }
        }
        if (col < board[0].length - 1 && board[row][col + 1] == s.charAt(0) && !vis[row][col + 1]) {
            if (recFind(row, col + 1, board, s.substring(1), vis)) {
                return true;
            }
        }
        vis[row][col] = false;
        return false;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recFind(word.substring(1), board, i, j, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean recFind(String s, char[][] board, int row, int col, boolean[][] vis) {
        if (s.length() == 0) {
            return true;
        }
        vis[row][col] = true;
        if (row > 0 && board[row - 1][col] == s.charAt(0) && !vis[row - 1][col] && recFind(s.substring(1), board, row - 1, col, vis)) {
            return true;
        }
        if (row < board.length - 1 && board[row + 1][col] == s.charAt(0) && !vis[row + 1][col] && recFind(s.substring(1), board, row + 1, col, vis)) {
            return true;
        }
        if (col > 0 && board[row][col - 1] == s.charAt(0) && !vis[row][col - 1] && recFind(s.substring(1), board, row, col - 1, vis)) {
            return true;
        }
        if (col < board[0].length - 1 && board[row][col + 1] == s.charAt(0) && !vis[row][col + 1] && recFind(s.substring(1), board, row, col + 1, vis)) {
            return true;
        }
        vis[row][col] = false;
        return false;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (!isRowValid(board)) {
            return false;
        }
        if (!isColumnValid(board)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isBoxValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isRowValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }
    private boolean isColumnValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        return true;
    }
    private boolean isBoxValid(char[][] board, int x, int y) {
        int xCenter = x * 3 + 1;
        int yCenter = y * 3 + 1;
        Set<Character> set = new HashSet<Character>();
        set.add(board[xCenter - 1][yCenter - 1]);
        if (board[xCenter][yCenter - 1] != '.') {
            if (set.contains(board[xCenter][yCenter - 1])) {
                return false;
            }
            set.add(board[xCenter][yCenter - 1]);
        }
        if (board[xCenter + 1][yCenter - 1] != '.') {
            if (set.contains(board[xCenter + 1][yCenter - 1])) {
                return false;
            }
            set.add(board[xCenter + 1][yCenter - 1]);
        }
        if (board[xCenter - 1][yCenter] != '.') {
            if (set.contains(board[xCenter - 1][yCenter])) {
                return false;
            }
            set.add(board[xCenter - 1][yCenter]);
        }
        if (board[xCenter][yCenter] != '.') {
            if (set.contains(board[xCenter][yCenter])) {
                return false;
            }
            set.add(board[xCenter][yCenter]);
        }
        if (board[xCenter + 1][yCenter] != '.') {
            if (set.contains(board[xCenter + 1][yCenter])) {
                return false;
            }
            set.add(board[xCenter + 1][yCenter]);
        }
        if (board[xCenter - 1][yCenter + 1] != '.') {
            if (set.contains(board[xCenter - 1][yCenter + 1])) {
                return false;
            }
            set.add(board[xCenter - 1][yCenter + 1]);
        }
        if (board[xCenter][yCenter + 1] != '.') {
            if (set.contains(board[xCenter][yCenter + 1])) {
                return false;
            }
            set.add(board[xCenter][yCenter + 1]);
        }
        if (board[xCenter + 1][yCenter + 1] != '.') {
            if (set.contains(board[xCenter + 1][yCenter + 1])) {
                return false;
            }
        }
        return true;
    }
}
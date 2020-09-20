class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int y = 0;
        int x = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
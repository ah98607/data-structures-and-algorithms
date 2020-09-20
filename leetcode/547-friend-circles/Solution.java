class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] vis = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!vis[i]) {
                count++;
                recFind(i, vis, M);
            }
        }
        return count;
    }
    private void recFind(int cur, boolean[] vis, int[][] M) {
        vis[cur] = true;
        for (int i = 0; i < M[cur].length; i++) {
            if (!vis[i] && M[cur][i] == 1) {
                recFind(i, vis, M);
            }
        }
    }
}
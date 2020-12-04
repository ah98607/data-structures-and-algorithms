class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] vis = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!vis[i]) {
                res++;
                recFind(i, M, vis);
            }
        }
        return res;
    }
    private void recFind(int cur, int[][] M, boolean[] vis) {
        vis[cur] = true;
        for (int i = 0; i < M[cur].length; i++) {
            if (!vis[i] && M[cur][i] == 1) {
                recFind(i, M, vis);
            }
        }
    }
}
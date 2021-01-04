class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] vis = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!vis[i]) {
                res++;
                recFind(M, i, vis);
            }
        }
        return res;
    }
    private void recFind(int[][] M, int cur, boolean[] vis) {
        vis[cur] = true;
        for (int i = 0; i < M[cur].length; i++) {
            if (!vis[i] && M[cur][i] == 1) {
                recFind(M, i, vis);
            }
        }
    }
}
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C- A) * (D - B) + (G- E) * (H- F);
        if (E > C || F > D || A > G || B > H) {
            return total;
        }
        int[] x = {A, E, C, G};
        int[] y = {B, F, D, H};
        Arrays.sort(x);
        Arrays.sort(y);
        return total - (x[2] - x[1]) * (y[2] - y[1]);
    }
}
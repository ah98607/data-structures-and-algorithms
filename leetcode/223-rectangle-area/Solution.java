class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        if (E > C || A > G || B > H || F > D) {
            return total;
        }
        int[] x = {A, C, E, G};
        int[] y = {B, D, F, H};
        Arrays.sort(x);
        Arrays.sort(y);
        return total - (x[2] - x[1]) * (y[2] - y[1]);
    }
}
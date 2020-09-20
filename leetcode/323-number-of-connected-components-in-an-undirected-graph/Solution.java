class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] group = new int[n]; // point i in which group
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int pA = edges[i][0];
            int pB = edges[i][1];
            int aAfterGrouping = merge(pA, group);
            int bAfterGrouping = merge(pB, group);
            if (aAfterGrouping != bAfterGrouping) {
                group[bAfterGrouping] = aAfterGrouping;
                count--;
            }
        }
        return count;
    }
    private int merge(int point, int[] group) {
        while (point != group[point]) {
            point = group[point];
        }
        return point;
    }
}
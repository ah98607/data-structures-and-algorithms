class Solution {
    final int div2 = Integer.MAX_VALUE / 2;
    final int div3 = Integer.MAX_VALUE / 3;
    final int div5 = Integer.MAX_VALUE / 5;
    public int nthUglyNumber(int n) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        Set<Integer> vis = new HashSet<Integer>();
        q.offer(1);
        vis.add(1);
        int res = 0;
        while (!q.isEmpty() && n > 0) {
            res = q.poll();
            if (res < div2) {
                int prod2 = res * 2;
                if (!vis.contains(prod2)) {
                    q.offer(prod2);
                    vis.add(prod2);
                }
            }
            if (res < div3) {
                int prod3 = res * 3;
                if (!vis.contains(prod3)) {
                    q.offer(prod3);
                    vis.add(prod3);
                }
            }
            if (res < div5) {
                int prod5 = res * 5;
                if (!vis.contains(prod5)) {
                    q.offer(prod5);
                    vis.add(prod5);
                }
            }
            n--;
        }
        return res;
    }
}
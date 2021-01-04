class Solution {
    final int div2 = Integer.MAX_VALUE / 2;
    final int div3 = Integer.MAX_VALUE / 3;
    final int div5 = Integer.MAX_VALUE / 5;
    public int nthUglyNumber(int n) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        Set<Integer> vis = new HashSet<Integer>();
        pq.offer(1);
        vis.add(1);
        int temp = 1;
        while (!pq.isEmpty() && n > 0) {
            temp = pq.poll();
            if (temp < div2) {
                int prod2 = temp * 2;
                if (!vis.contains(prod2)) {
                    vis.add(prod2);
                    pq.offer(prod2);
                }
            }
            if (temp < div3) {
                int prod3 = temp * 3;
                if (!vis.contains(prod3)) {
                    vis.add(prod3);
                    pq.offer(prod3);
                }
            }
            if (temp < div5) {
                int prod5 = temp * 5;
                if (!vis.contains(prod5)) {
                    vis.add(prod5);
                    pq.offer(prod5);
                }
            }
            n--;
        }
        return temp;
    }
}
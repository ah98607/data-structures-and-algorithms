class Solution {
    final int div2 = Integer.MAX_VALUE / 2;
    final int div3 = Integer.MAX_VALUE / 3;
    final int div5 = Integer.MAX_VALUE / 5;
    public int nthUglyNumber(int n) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        Set<Integer> vis = new HashSet<Integer>();
        pq.offer(1);
        vis.add(1);
        int temp = 0;
        while (n > 0 && !pq.isEmpty()) {
            temp = pq.poll();
            if (temp < div2) {
                int prod2 = temp * 2;
                if (!vis.contains(prod2)) {
                    vis.add(prod2);
                    pq.add(prod2);
                }
            }
            if (temp < div3) {
                int prod3 = temp * 3;
                if (!vis.contains(prod3)) {
                    vis.add(prod3);
                    pq.add(prod3);
                }
            }
            if (temp < div5) {
                int prod5 = temp * 5;
                if (!vis.contains(prod5)) {
                    vis.add(prod5);
                    pq.add(prod5);
                }
            }
            n--;
        }
        return temp;
    }
}
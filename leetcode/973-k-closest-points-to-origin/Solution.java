class Point {
    int x;
    int y;
    int dist;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        dist = x * x + y * y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.dist - p2.dist;
            }
        });
        for (int i = 0; i < points.length; i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
}
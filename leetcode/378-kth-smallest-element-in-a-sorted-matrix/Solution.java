class Elem {
    int row;
    int col;
    int val;
    public Elem(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Elem> pq = new PriorityQueue<Elem>(new Comparator<Elem>() {
            public int compare(Elem e1, Elem e2) {
                return e1.val - e2.val;
            }
        });
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        pq.offer(new Elem(0, 0, matrix[0][0]));
        vis[0][0] = true;
        Elem temp = null;
        while (k > 0 && !pq.isEmpty()) {
            temp = pq.poll();
            int r = temp.row;
            int c = temp.col;
            if (r < matrix.length - 1 && !vis[r + 1][c]) {
                vis[r + 1][c] = true;
                pq.offer(new Elem(r + 1, c, matrix[r + 1][c]));
            }
            if (c < matrix[0].length - 1 && !vis[r][c + 1]) {
                vis[r][c + 1] = true;
                pq.offer(new Elem(r, c + 1, matrix[r][c + 1]));
            }
            k--;
        }
        return temp.val;
    }
}
class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Interval> join = new ArrayList<Interval>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA][0] > B[indexB][1]) {
                indexB++;
            }
            else if (B[indexB][0] > A[indexA][1]) {
                indexA++;
            }
            else {
                join.add(new Interval(Math.max(A[indexA][0], B[indexB][0]), Math.min(A[indexA][1], B[indexB][1])));
                if (B[indexB][1] > A[indexA][1]) {
                    indexA++;
                }
                else {
                    indexB++;
                }
            }
        }
        int[][] res = new int[join.size()][2];
        for (int i = 0; i < join.size(); i++) {
            res[i][0] = join.get(i).start;
            res[i][1] = join.get(i).end;
        }
        return res;
    }
}
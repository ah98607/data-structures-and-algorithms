class Solution {
    public int[] sortedSquares(int[] A) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < A.length; i++) {
            pq.offer(A[i] * A[i]);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
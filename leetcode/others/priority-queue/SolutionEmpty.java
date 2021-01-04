class PriorityQueue {
    public PriorityQueue(int capacity) {
    }
    public void offer(int num) {
    }
    public int poll() {
    }
    public int peek() {
    }
    private void trickleUp(int cur) {
    }
    private void trickleDown(int cur) {
    }
}
public class Solution {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.offer(5);
        pq.offer(3);
        pq.offer(4);
        pq.offer(1);
        System.out.println("Size: " + pq.size());
        pq.peek();
        pq.poll();
        System.out.println("Size: " + pq.size());
        pq.peek();
        pq.offer(2);
        pq.peek();
        pq.offer(7);
        pq.offer(8);
        while (pq.size() != 0) {
            pq.poll();
        }
    }
}
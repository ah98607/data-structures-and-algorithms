class PriorityQueue {
    int[] nums;
    int size;
    public PriorityQueue(int capacity) {
        nums = new int[capacity];
    }
    public void offer(int num) {
        if (size == nums.length) {
            System.out.println("Full");
            return;
        }
        nums[size++] = num;
        trickleUp(size - 1);
    }
    public int poll() {
        if (size == 0) {
            System.out.println("Empty");
            return -1;
        }
        int temp = nums[0];
        nums[0] = nums[size-- - 1];
        trickleDown(0);
        System.out.println("Poll -> " + temp);
        return temp;
    }
    public int peek() {
        if (size == nums.length) {
            System.out.println("Empty");
            return -1;
        }
        System.out.println("Peek -> " + nums[0]);
        return nums[0];
    }
    public int size() {
        return size;
    }
    private void trickleUp(int cur) {
        while (cur != 0) {
            int parent = (cur - 1) / 2;
            if (nums[cur] < nums[parent]) {
                int temp = nums[parent];
                nums[parent] = nums[cur];
                nums[cur] = temp;
                cur = parent;
            }
            else {
                break;
            }
        }
    }
    private void trickleDown(int cur) {
        while (cur < size / 2) {
            int left = cur * 2;
            int right = left + 1;
            if (nums[left] < nums[cur]) {
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                cur = left;
            }
            else if (right < size && nums[right] < nums[cur]) {
                int temp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = temp;
                cur = right;
            }
            else {
                break;
            }
        }
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
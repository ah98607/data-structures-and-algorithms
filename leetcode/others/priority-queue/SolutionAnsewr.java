class PriorityQueue {
    int[] nums;
    int size;
    int capacity;
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        nums = new int[capacity];
    }
    public void offer(int num) {
        if (size == capacity) {
            System.out.println("offer failed because of full");
            return; // exception
        }
        System.out.println("offer " + num);
        nums[size++] = num;
        trickleUp(size - 1);
    }
    public int poll() {
        if (size == 0) {
            System.out.println("poll failed because empty");
            return -1; // exception
        }
        int temp = nums[0];
        nums[0] = nums[size-- - 1];
        trickleDown(0);
        System.out.println("poll: " + temp);
        return temp;
    }
    public int peek() {
        if (size == 0) {
            System.out.println("peek failed because empty");
            return -1;
        }
        System.out.println("peek: " + nums[0]);
        return nums[0];
    }
    public int size() {
        return size;
    }
    private void trickleUp(int cur) {
        int temp = nums[cur];
        while (cur > 0) {
            int parent = (cur - 1) / 2;
            if (nums[parent] > temp) {
                nums[cur] = nums[parent];
                cur = parent;
            }
            else {
                break;
            }
        }
        nums[cur] = temp;
    }
    private void trickleDown(int cur) {
        int temp = nums[cur];
        while (cur < size / 2) {
            int left = 2 * cur + 1;
            int right = left + 1;
            if (right < size && nums[right] < nums[left]) {
                if (nums[right] < temp) {
                    nums[cur] = nums[right];
                    cur = right;
                }
                else {
                    break;
                }
            }
            else {
                if (nums[left] < temp) {
                    nums[cur] = nums[left];
                    cur = left;
                }
                else {
                    break;
                }
            }
        }
        nums[cur] = temp;
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
    }
}
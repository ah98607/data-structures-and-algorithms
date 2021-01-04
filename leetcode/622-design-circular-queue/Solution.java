class MyCircularQueue {
    int[] nums;
    int size;
    int front;
    int rear;
    public MyCircularQueue(int k) {
        nums = new int[k];
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear++;
        if (rear == nums.length) {
            rear = 0;
        }
        nums[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front++;
        if (front == nums.length) {
            front = 0;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == nums.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
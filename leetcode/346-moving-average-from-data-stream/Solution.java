class MovingAverage {
    Queue<Integer> q;
    int capacity;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        capacity = size;
    }
    
    public double next(int val) {
        if (q.size() == capacity) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return (double) sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
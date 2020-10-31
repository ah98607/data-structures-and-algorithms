class MedianFinder {
    Queue<Integer> q1;
    Queue<Integer> q2;
    /** initialize your data structure here. */
    public MedianFinder() {
        q1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        q2 = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(num);
        }
        else if (q1.size() == q2.size() - 1) {
            if (num > q2.peek()) {
                q1.offer(q2.poll());
                q2.offer(num);
            }
            else {
                q1.offer(num);
            }
        }
        else if (q1.size() - 1 == q2.size()) {
            if (num < q1.peek()) {
                q2.offer(q1.poll());
                q1.offer(num);
            }
            else {
                q2.offer(num);
            }
        }
        else {
            if (num > q2.peek()) {
                q2.offer(num);
            }
            else {
                q1.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (q1.size() == q2.size() - 1) {
            return q2.peek();
        }
        if (q1.size() - 1 == q2.size()) {
            return q1.peek();
        }
        return (q1.peek() + q2.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
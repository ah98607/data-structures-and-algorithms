class QE {
    int val;
    SE se;
    int id;
    boolean removed;
    public QE(int val, int id) {
        this.val = val;
        this.id = id;
    }
}
class SE {
    int val;
    QE qe;
    boolean removed;
    public SE(int val) {
        this.val = val;
    }
}
class MaxStack {
    Stack<SE> stack;
    Queue<QE> pq;
    int id;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<SE>();
        pq = new PriorityQueue<QE>(new Comparator<QE>() {
            public int compare(QE e1, QE e2) {
                if (e1.val != e2.val) {
                    return e2.val - e1.val;
                }
                return e2.id - e1.id;
            }
        });
    }
    
    public void push(int x) {
        SE se = new SE(x);
        QE qe = new QE(x, id++);
        se.qe = qe;
        qe.se = se;
        stack.push(se);
        pq.offer(qe);
    }
    
    public int pop() {
        while (!stack.isEmpty() && stack.peek().removed) {
            stack.pop();
        }
        SE temp = stack.pop();
        temp.qe.removed = true;
        return temp.val;
    }
    
    public int top() {
        while (!stack.isEmpty() && stack.peek().removed) {
            stack.pop();
        }
        return stack.peek().val;
    }
    
    public int peekMax() {
        while (!pq.isEmpty() && pq.peek().removed) {
            pq.poll();
        }
        return pq.peek().val;
    }
    
    public int popMax() {
        while (!pq.isEmpty() && pq.peek().removed) {
            pq.poll();
        }
        QE temp = pq.poll();
        temp.se.removed = true;
        return temp.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
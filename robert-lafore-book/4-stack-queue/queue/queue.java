class Queue {
	private int maxSize;
	private long[] a;
	private int rear;
	private int front;
	private int nItems;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		a = new long[this.maxSize];
		nItems = 0;
		front = 0;
		rear = -1;
	}
	public void insert(long value) {

		// deal with wrap around
		if(rear == maxSize-1) {
			rear = -1;
		}

		a[++rear] = value;// important: increase rear pointer first, then write value to that location
		nItems++;
	}
	public long remove() {
		
		// deal with wrap around
		if(front == maxSize) {
			front = 0;
		}
		long temp = a[front++];// important: load that location first, then increase front pointer
		nItems--;
		return temp;
	}
	public long peek() {
		return a[front];
	}
	public boolean isEmpty() {
		return (nItems == 0);
	}
	public boolean isFull() {
		return (nItems == maxSize);
	}
	public int size() {
		return nItems;
	}
}

class QueueApp {
	public static void main(String[] args) {
		Queue q;
		q = new Queue(5);

		q.insert(3);
		q.insert(4);
		System.out.println("First remove: "+q.remove());
		q.insert(8);
		System.out.println("Second remove: "+q.remove());
	}
}
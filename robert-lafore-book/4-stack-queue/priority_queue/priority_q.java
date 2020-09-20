class PriorityQ {
	private int nItems;
	private long[] a;
	private int maxSize;
	
	public PriorityQ(int maxSize) {
		this.maxSize = maxSize;
		a = new long[this.maxSize];
		nItems = 0;
	}
	public void insert(long value) {//from o to n, value increases (the smallest one at first)
		nItems++;
		int i = nItems-1;
		while(i>0 && value<a[i-1]) {
			a[i] = a[i-1];
			i--;
		}
		a[i] = value;
	}
	public long remove() {
		return a[--nItems];//it should be get value first and then decrese, but note that we want get q[nItems-1]
	}
	public long peek() {
		return a[nItems-1];
	}
	public boolean isFull() {
		return (nItems == maxSize);
	}
	public boolean isEmpty() {
		return (nItems == 0);
	}
}
class PriorityQApp {
	public static void main(String[] args) {
		PriorityQ q = new PriorityQ(10);
		q.insert(2);
		q.insert(7);
		q.insert(5);
		q.insert(4);
		while(!q.isEmpty()) {
			System.out.print(q.remove()+", ");
		}
	}
}
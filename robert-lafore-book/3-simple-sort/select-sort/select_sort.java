class ArraySel {

	private long[] a;
	private int nElements;

	public ArraySel(int i) {
		a = new long[i];
		nElements = 0;
	}

	public void insert(long value) {
		a[nElements++] = value;
	}

	public void display() {
		for(int i=0; i<nElements; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(" ");
	}

	public void selectSort() {
		int out;
		int in;
		int index_smallest; // used to record smallest element in the inner loop
		for(out=0; out < nElements-1; out++) {
			index_smallest = out+1;
			for(in=index_smallest; in<nElements; in++) {
				if(a[in] < a[index_smallest]) index_smallest = in;
			}
			swap(out, index_smallest);
		}
	}
	private void swap(int index_a, int index_b) {
		long temp = a[index_a];
		a[index_a] = a[index_b];
		a[index_b] = temp;
	}
}

class SelectSortApp {
	public static void main(String args[]) {
		ArraySel myArray = new ArraySel(100);
		myArray.insert(23);
		myArray.insert(53);
		myArray.insert(64);
		myArray.insert(29);
		myArray.insert(36);
		myArray.insert(78);
		myArray.insert(61);
		myArray.insert(92);
		myArray.insert(65);
		myArray.insert(12);

		myArray.display();
		myArray.selectSort();
		myArray.display();
	}
}
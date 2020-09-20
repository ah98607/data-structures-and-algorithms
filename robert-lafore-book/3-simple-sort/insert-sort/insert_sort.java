class ArrayIns {
	private long[] a;
	private int nElements;
	public ArrayIns(int i) {
		a = new long[i];
		nElements = 0;
	}
	public void insert(long value) {
		a[nElements] = value;
		nElements++;
	}
	public void display() {
		for(int i=0; i<nElements; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(" ");
	}
	public void insertSort() {
		int in, out;
		/* text book example
		for(out=1; out<nElements; out++) {
			long temp = a[out];
			in=out;
			while(in>0 && a[in-1] >= temp) {
				a[in]=a[in-1];
				--in;
			}
			a[in] = temp; //insert;
		}*/
		for(out=0; out<nElements-1; out++) {
			long temp = a[out+1];//the one to be inserted
			for(in=out; in>=0; in--) {
				if(a[in]>temp) {
					// move element right
					a[in+1] = a[in];
				}
				else {
					break;
				}
			}//end internal loop
			
			// in+1 is because after doing "break", "in" decreases when exiting
			a[in+1] = temp;
		}//end external loop
	}//end insertSort()
}

class InsertSortApp {
	public static void main(String args[]) {
		ArrayIns myArray = new ArrayIns(100);
		myArray.insert(3);
		myArray.insert(2);
		myArray.insert(1);
		myArray.insert(29);
		myArray.insert(36);
		myArray.insert(78);
		myArray.insert(61);
		myArray.insert(92);
		myArray.insert(65);
		myArray.insert(12);

		myArray.display();
		myArray.insertSort();
		myArray.display();
	}
}
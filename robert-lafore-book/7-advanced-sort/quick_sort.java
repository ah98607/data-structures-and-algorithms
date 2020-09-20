// Things to remember
// 1. while loop with empty body to ensure index increments
// 2. use > and < in partition
// 3. no need to use leftPtr<right because we choose right most to be pivot
// 4. swap pivot and leftPrt
class OldArray {
	public long[] a;
	public int nElems;

	public OldArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long data) {
		System.out.println("Inserting "+data);
		a[nElems++] = data;
	}

	public void display() {
		System.out.print("Current array: ");
		for(int i=0; i<nElems; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("");
	}

	// note that for all programs using recursive calling
	// we use a similar non-argument wrapper to contain the recursive calling
	public void quikSort() {
		recQuickSort(0, nElems-1);
	}

	// recursive flow: partition and recQuickSort the two divided arrays
	// compare this with merge sort (which is recMergeSort two arrays and merge them)
	private void recQuickSort(int left, int right) {
		
		if(right-left <= 0) {
			return; // force return
		}
		else {
			// get the index of partition point
			int par_location = partition(left, right, a[right]); // use right most element as pivot

			recQuickSort(left, par_location-1);
			recQuickSort(par_location+1, right);
		}
	}

	// partition method returns [1+(index to the last element of the left sub-array)]
	public int partition(int left, int right, long pivot) {
		// we make it left-1 that leftPtr points to left most  after ++leftPtr
		// this makes the *Ptr easy to understand below
		int leftPtr = left-1;

		// important: skip the ight most one since it is pivot
		// we make it right that leftPtr points to SECOND right most after --rightPtr
		// this makes the *Ptr easy to understand below
		int rightPtr = right; 

		while(true) {

			// note that we use empty body for the following two while loops
			// this ensures *Ptr keep changing even during the last iteration (of internal loop)
			// otherwise *Ptr will does increment/decrease
			// the next iteration of outter loop will get a wrong *Ptr value

			// no need to use leftPtr<right, because right is the pivot
			while(a[++leftPtr]<pivot);
			while(rightPtr>0 && a[--rightPtr]>pivot);

			// pay attention to the value of leftPtr and rightPtr at this time
			if(leftPtr >= rightPtr) {
				// partition is done
				break;
			}
			else {
				swap(leftPtr, rightPtr);
			}
		}

		// adjust the position of pivot
		swap(leftPtr, right);

		return leftPtr;
	}

	private void swap(int x, int y) {
		long temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}
}

class QuickSortApp {
	public static void main(String[] args) {
		int partition;

		OldArray myArray = new OldArray(10);
		myArray.insert(5);
		myArray.insert(10);
		myArray.insert(6);
		myArray.insert(92);
		myArray.insert(12);
		myArray.insert(54);
		myArray.display();

		/*System.out.println("");
		partition = myArray.partition(0, myArray.nElems-1, 54);
		System.out.println("Partition index: "+partition);
		myArray.display();
		System.out.println("");*/

		myArray.quikSort();
		myArray.display();
	}
}
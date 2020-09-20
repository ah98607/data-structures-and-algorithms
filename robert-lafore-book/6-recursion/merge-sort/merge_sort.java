class OldArray {
	public long[] a;
	public int nElems;

	public OldArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long key) { // this is a simple insert, unlike the one in binary search
		a[nElems++] = key;
	}

	public void display() {
		for(int i=0; i<nElems; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println("");
	}

	public void mergeSort() {
		long[] workSpace = new long[nElems]; // this temp array will be used in the whole recursive process
		recMergeSort(workSpace, 0, nElems-1);
	}

	// note that array will be passed as a reference
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound) {
			return;
		}
		else {
			int mid = (lowerBound+upperBound)/2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowerBound, int upperBound) {
		int j = 0;
		int mid = (lowerBound+upperBound)/2;
		int lowPtr = lowerBound;
		int highPtr = mid+1;
		int n = upperBound - lowerBound + 1;

		while(lowPtr<=mid && highPtr<=upperBound) {
			if(a[lowPtr] < a[highPtr]) {
				workSpace[j] = a[lowPtr];
				j++;
				lowPtr++;
			}
			else {
				workSpace[j] = a[highPtr];
				j++;
				highPtr++;
			}
		}
		while(lowPtr<=mid) {
			workSpace[j] = a[lowPtr];
			j++;
			lowPtr++;
		}
		while(highPtr<=upperBound) {
			workSpace[j] = a[highPtr];
			j++;
			highPtr++;
		}

		for(int m=0; m<n; m++) {
			a[lowerBound+m] = workSpace[m];
		}
	}
}

class MergeSortApp {
	public static void main(String[] args) {
		OldArray myArray = new OldArray(10);
		myArray.insert(5);
		myArray.insert(2);
		myArray.insert(31);
		myArray.insert(21);
		myArray.insert(65);
		myArray.insert(88);
		myArray.insert(53);
		myArray.insert(83);
		myArray.insert(29);
		myArray.insert(109);
		myArray.display();

		System.out.println("Merge sort:");
		myArray.mergeSort();
		myArray.display();
	}
}
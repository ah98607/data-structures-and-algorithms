// also pay attention to how insert is done
class OldClass {

	public long[] a;
	public int nElems;

	public OldClass(int max) {
		a = new long[max];
		nElems = 0;
	}

	// this method returns the index of wanted key
	// a separate method should be used so that different arguments can be passed in different iterations
	public int find(long key) {
		System.out.print("d");
		return rec_find(key, 0, nElems);
	}

	private int rec_find(long key, int lower_bound, int upper_bound) {

		int middle_point = (lower_bound+upper_bound)/2; //note it will be converted into int type
		if(a[middle_point] == key) {
			System.out.print("a");
			return middle_point;
		}
		else if(a[middle_point] < key) {
			// go to right part
			System.out.print("b");
			lower_bound = middle_point + 1; // notice that the middle point is skipped
			return rec_find(key, lower_bound, upper_bound);
		}
		else {
			// go to left part
			System.out.print("c");
			upper_bound = middle_point - 1;
			return rec_find(key, lower_bound, upper_bound);
		}
	}

	// note inserting is special because the array must be in order: small -> large
	// this is actually the same as the priority queue
	// this is very important insert pattern, memorize it
	public void insert(long value) {

			int current = nElems; // note at the beginning of the 1st iteration, a[i] points to a null element

			while(current>0 && value<a[current-1]) {
				a[current] = a[current-1];
				current--;
			}
			a[current] = value;
			nElems++;
		/* the following implementation is OK, but looks stupid
		int current = 0;
		for(current=0; current<nElems; current++) { // find the location to put the new element
			if(value<a[current]) {
				break;
			}
		}
		for(int i=nElems; i>current; i--) { // note that a[nElems] is empty before runing
			a[i] = a[i-1];
		}
		a[current] = value;
		nElems++;
		*/
	}

	public void display() {
		System.out.print("Current array is: ");
		for(int i=0; i<nElems; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println(" ");
	}
}

class BinarySearchApp {
	public static void main(String[] args) {
		OldClass myArray = new OldClass(10);

		System.out.println("Inserting 5");
		myArray.insert(5);
		myArray.display();

		System.out.println("Inserting 7");
		myArray.insert(7);
		myArray.display();

		System.out.println("Inserting 2");
		myArray.insert(2);
		myArray.display();

		System.out.println("Inserting 3");
		myArray.insert(3);
		myArray.display();

		System.out.println("Inserting 9");
		myArray.insert(9);
		myArray.display();

		System.out.println("////////////////////");
		for(int m=0; m<myArray.nElems; m++) {
			System.out.println("Searching "+myArray.a[m]);
			System.out.println("The index of searched key is: "+myArray.find(myArray.a[m]));
		}
	}
}
// unlike BST, heap is considered as an array of data nodes.
// nodes do not have child pointers.

// something to remember (IMPORTANT!!)
// parent (x-1)/2
// left child 2x+1
// right child 2x+2

class Node {
	int iData;
	public Node(int data) {
		iData = data;
	}
}

class Heap {
	Node[] nArray; // node array
	int maxSize;
	int nElems;

	public Heap(int size) {
		maxSize = size;
		nArray = new Node[maxSize];
		nElems = 0; //current size
	}

	public void insert(int data) {
		
		System.out.println("Inserting "+data+".");

		if(nElems == maxSize-1) {
			System.out.println("Error: trying to insert a node to a full heap.");
		}
		else {
			nElems++;
			nArray[nElems-1] = new Node(data); // store new node in (new) last elem of the array
			trickleUp(nElems-1); // trickle up from the last node
			
		}
	}

	public Node remove() {
		//
		if(nElems == 0) {
			System.out.println("Error: trying to remove a node from an empty heap.");
			return null;
		}
		else {
			Node temp = nArray[0]; // remove root and store in temp
			nArray[0] = nArray[nElems-1]; // move the last node to root
			nElems--;
			trickleDown(0); // trickle down from the root node
			return temp; // return the temp node
		}
	}

	public void trickleUp(int index) {
		// note that the parent node is (x-1)/2
		Node temp = nArray[index];
		int current = index;
		int parent;

		while(current>0) {

			parent = (current-1)/2;

			if(temp.iData > nArray[parent].iData) {
				nArray[current] = nArray[parent];
				current = parent;
				System.out.println("New node moved up.");
				// actually the thing is that the "empty hole" (potential spot for newly added node) moves down
			}
			else {
				break;
			}
		}

		// note that this assignment cannot be put right above "break" statement
		// otherwise this assignment will not be done if "else" never trigered
		nArray[current] = temp;
	}

	public void trickleDown(int index) {
		//
		Node temp = nArray[index]; // store the starting node
		int current = index;
		int left, right;

		// note "current<nElems/2" (the last possible current = nElems/2 - 1)
		//if current>=nElems/2. then left child will have index nElems+1, which is not good
		while(current<nElems/2) {

			left = 2*current+1;
			right = left+1;

			// if right exists and it's largr than left
			if(right<nElems && nArray[right].iData>nArray[left].iData) {
				
				if(nArray[right].iData > temp.iData) {
					nArray[current] = nArray[right];
					current = right;
					System.out.println("Last node with data moved (right) down after being put at root.");
				}
				else {
					break;
				}
			}
			else {
				if(nArray[left].iData > temp.iData) {
					nArray[current] = nArray[left];
					current = left;
					System.out.println("Last node with data moved (left) down after being put at root.");
				}
				else {
					break;
				}
			}
		}

		// note that this assignment cannot be put right above "break" statement
		// otherwise this assignment will not be done if "else" never trigered
		nArray[current] = temp;
	}

	public void change(int index, int data) {
		int originalData = nArray[index].iData;
		nArray[index] = new Node(data);
		if(data > originalData) {
			trickleUp(index);
		}
		else {
			trickleDown(index);
		}
	}

	public void displayHeap() {
		System.out.print("Node array: ");
		for(int i=0; i<nElems; i++)
			System.out.print(nArray[i].iData+", ");
		System.out.println(" ");
	}
}

class HeapApp {
	public static void main(String[] args) {
		Heap myHeap = new Heap(20);
		myHeap.insert(5);
		myHeap.displayHeap();
		myHeap.insert(1);
		myHeap.displayHeap();
		myHeap.insert(8);
		myHeap.displayHeap();
		myHeap.insert(11);
		myHeap.displayHeap();
		
		myHeap.remove();
		myHeap.displayHeap();
		myHeap.remove();
		myHeap.displayHeap();
		myHeap.remove();
		myHeap.displayHeap();
		myHeap.remove();
		myHeap.displayHeap();

		System.out.println("Now recover all noes and test node data changing.");
		myHeap.insert(5);
		myHeap.insert(1);
		myHeap.insert(8);
		myHeap.insert(11);
		myHeap.displayHeap();

		myHeap.change(0, 3); // change node 0 (11) to 3
		myHeap.displayHeap();
		myHeap.change(2, 99); // change node 2 (5) to 99
		myHeap.displayHeap();
		myHeap.change(3, 101); // change node 3 (1) to 101
	}
}

// this is the basic sorting based on heap, without the optimized ideas on the textbook
class HeapSortApp {
	public static void main(String[] args) {
		Heap myHeap = new Heap(20);
		int[] myArray = {21, 34, 11, 4, 39, 48, 82, 62, 20, 59};

		for(int i=0; i<10; i++) {
			myHeap.insert(myArray[i]);
		}
		myHeap.displayHeap();

		System.out.println(" ");
		for(int i=0; i<10; i++) {
			myArray[i] = myHeap.remove().iData;
			myHeap.displayHeap();
		}

		// check newly generated array
		System.out.print("After sorting, the array becomes: ");
		for(int i=0; i<10; i++) {
			System.out.print(myArray[i]+", ");
		}
	}
}
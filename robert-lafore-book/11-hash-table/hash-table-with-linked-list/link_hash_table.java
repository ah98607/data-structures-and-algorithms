// this one uses linked list in hash table
class Link { // link replaces the "DataItem" class
	public int iData;
	public Link next;

	public Link(int data) {
		iData = data;
	}

	public int getKey() {
		return iData;
	}
}

// note that a sorted link list is used
// it implements insert and remove[first] methods
class LinkList {
	public Link first;

	public LinkList() {
		first = null;
	}

	public void insert(int data) { // review how insert is done in the sorted link list
		
		Link temp = new Link(data);
		Link current = first;
		Link previous = first;

		while(current!=null && data>current.getKey()) { // inside the list, smaller -> larger
			previous = current;
			current = current.next;
		}
		if(current == first) { // insert first
			temp.next = first;
			first = temp;
		}
		else if(current == null) { // insert last
			previous.next = temp;
		}
		else { // insert in the middle
			temp.next = current;
			previous.next = temp;
		}
	}

	public Link delete(int data) {
		Link current = first;
		Link previous = first;

		System.out.println("Trying to delte the link with data "+data);

		// go to the link with the data
		while(current!=null && current.getKey()!=data) {
			previous = current;
			current = current.next;
		}

		// do things below after exiting the loop
		if(current == null) {
			System.out.println("Error: link with the specified data not found.");
			return null;
		}
		else {
			Link temp = current;
			if(current == first) {
				first = first.next;
			}
			else {
				previous.next = current.next;
			}
			System.out.println("Removed the link with specified data ("+temp.getKey()+") successfully.");
			return temp;
		}
	}

	public Link find(int data) {
		Link current = first;
		Link previous = first;

		System.out.println("Trying to find the link with data "+data);

		// go to the link with the data
		while(current!=null && current.getKey()!=data) {
			previous = current;
			current = current.next;
		}
		if(current == null) {
			System.out.println("Error: link with the specified data not found.");
			return null;
		}
		else {
			System.out.println("Found the link with specified data successfully.");
			return current;
		}
	}

	public void displayList() {
		Link current = first;
		while(current != null) {
			System.out.print(current.getKey()+", ");
			current = current.next;
		}

		System.out.println(" ");
	}
}

class HashTable {
	LinkList[] myArray;
	int arraySize;

	public HashTable(int size) {
		arraySize = size;
		myArray = new LinkList[arraySize];
		for(int i=0; i<arraySize; i++) { // IMPORTANT: we have to do this!! Compare this with the one used in simple hash table
			myArray[i] = new LinkList();
		}
	}

	public void insert(int data) {
		int index = HashFunc(data);
		myArray[index].insert(data);
		System.out.println("Inserting "+data+" (hashed index is "+index+".");
	}

	public Link delete(int data) {
		System.out.println("Trying to relete "+data+".");
		int index = HashFunc(data);
		Link temp = myArray[index].delete(data);
		return temp;
	}

	public Link find(int data) {
		System.out.println("Trying to find "+data+".");
		int index = HashFunc(data);
		Link temp = myArray[index].find(data);
		return temp;
	}

	public void displayTable() {
		System.out.println("Printing the hash table below.");
		for(int i=0; i<arraySize; i++) {
			System.out.print("Array #"+i+": ");
			myArray[i].displayList();
		}
	}

	public int HashFunc(int data) {
		return data%arraySize;
	}
}

class HashTableApp {
	public static void main(String[] args) {
		System.out.println("Creating a hash table of 10 spots.");
		HashTable myArray = new HashTable(10);

		myArray.insert(32);
		myArray.insert(42);
		myArray.insert(52);
		myArray.insert(18);
		myArray.insert(27);
		myArray.insert(67);

		myArray.displayTable();

		
		myArray.find(1);
		myArray.find(52);

		myArray.delete(18);
		myArray.delete(21);

		myArray.displayTable();

		myArray.delete(67);

		myArray.displayTable();
	}
}
// code 1: sorted list
// code 2: sorting by using this list
class Link {
	public int data;
	public Link next;
	public Link(int data) {
		this.data = data;
	}
	public void displayLink() {
		System.out.print(data+", ");
	}
}

class SortedList {
	public Link first;
	public SortedList() {
		first = null;
	}

	// core of sorted link list
	// from first to last, large -> small
	// this method is more complex than any insert method in
	// normal link list or first_last link list
	// because it could be insert_fist, insert_last, or insert
	// in the middle
	public void insert(int data) {
		
		Link temp = new Link(data);
		Link current = first;
		Link previous = first;

		while(current != null && current.data < data) {
			previous = current;
			current = current.next;
		} // go to the link that new data should be stored in

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

	// remove the link with the largest data
	// equivalent to removeFirst() in simply link list
	public Link remove() {
		if(first != null) {
			Link temp = first;
			first = first.next;
			return temp;
		}
		else {
			System.out.println("Error: trying to remove a link from an empty sorted link list.");
			return null;
		}
	}

	public void displayList() {
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" "); // go to next line after a list has been printed completely
	}
}

class SortedListApp {
	public static void main(String[] args) {
		SortedList my_list = new SortedList();

		my_list.insert(5);
		my_list.displayList();

		my_list.insert(21);
		my_list.displayList();

		my_list.insert(13);
		my_list.displayList();

		my_list.insert(97);
		my_list.displayList();

		my_list.insert(1);
		my_list.displayList();
	}
}

class SortingApp {
	public static void main(String[] args) {
		SortedList my_list = new SortedList();

		int[] my_array = {13, 23, 92, 62, 8, 93, 67, 2, 13, 1};

		System.out.println("Begin sorting.");
		for(int i=0; i<10; i++) {
			System.out.println("Inserting "+my_array[i]);
			my_list.insert(my_array[i]);
			System.out.print("After inserting, the sorted list looks like: ");
			my_list.displayList();
		}
		for(int i = 0; i<10; i++) {
			my_array[i] = my_list.remove().data;
		}
		System.out.println("Finish sorting.");

		for(int i=0; i<10; i++) {
			System.out.print(my_array[i]+", ");
		}

	}
}
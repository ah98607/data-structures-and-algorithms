class Link {
	public int data;
	public Link next;
	public Link previous; // newly added to the earlier FirstLastLink class
	public Link(int data) {
		this.data = data;
	}
	public void displayLink() {
		System.out.print(data+", ");
	}
}

class DoublyLinkList {
	public Link first;
	public Link last;

	public DoublyLinkList() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return (first==null);
	}
	public void insertFirst(int data) {
		Link temp = new Link(data);
		if(isEmpty()) {
			temp.next = null;
			temp.previous = null; // newly added to the earlier FirstLastLink class
			first = temp;
			last = temp;
		}
		else {
			temp.previous = null; // newly added to the earlier FirstLastLink class
			temp.next = first;
			first.previous = temp; // newly added to the earlier FirstLastLink class
			first = temp;
		}
	}

	public void insertLast(int data) {
		Link temp = new Link(data);
		if(isEmpty()) {
			temp.next = null;
			temp.previous = null; // newly added to the earlier FirstLastLink class
			first = temp;
			last = temp;
		}
		else {
			temp.previous = last; // newly added to the earlier FirstLastLink class
			temp.next = null;
			last.next = temp;
			last = temp;
		}
	}

	public Link deleteFirst() {
		if(isEmpty()) {
			System.out.println("Error: trying to delete link from an empty list.");
			return null;
		}
		else {
			Link temp = first;
			if(first.next == null) { // delete the only one link
				last = null;
				first = null;
			}
			else {
				first.next.previous = null; // newly added to the earlier FirstLastLink class
				first = first.next;
			}
			return temp;
		}
	} // must ensure list is not empty

	public Link deleteLast() {
		if(isEmpty()) {
			System.out.println("Error: trying to delete link from an empty list.");
			return null;
		}
		else {
			Link temp = last;
			if(first.next == null) { // delete the only one link
				first = null;
				last = null;
			}
			else {
				last.previous.next = null; // newly added to the earlier FirstLastLink class
				last = last.previous; // newly added to the earlier FirstLastLink class
			}
			return temp;
		}
	}

	public void displayList() {
		Link current = first;
		System.out.print("Current list: ");
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}

class DoublyLinkListApp {

	public static void main(String[] args) {

		DoublyLinkList myDoublyLinkList = new DoublyLinkList();

		System.out.println("Before inserting the first link, try print the link list.");
		myDoublyLinkList.displayList();

		System.out.println("Inserting 32.");
		myDoublyLinkList.insertFirst(32);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 73");
		myDoublyLinkList.insertFirst(73);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 93 at end");
		myDoublyLinkList.insertLast(93);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 19 at end");
		myDoublyLinkList.insertLast(19);
		myDoublyLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteFirst().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteFirst().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteFirst().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteFirst().data);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 19 at end");
		myDoublyLinkList.insertLast(19);
		myDoublyLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteFirst().data);
		myDoublyLinkList.displayList();

		System.out.println("////////////////////////////////////////");
		System.out.println("////////////////////////////////////////");

		System.out.println("Inserting 32.");
		myDoublyLinkList.insertFirst(32);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 73");
		myDoublyLinkList.insertFirst(73);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 93 at end");
		myDoublyLinkList.insertLast(93);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 19 at end");
		myDoublyLinkList.insertLast(19);
		myDoublyLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteLast().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteLast().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteLast().data);
		myDoublyLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteLast().data);
		myDoublyLinkList.displayList();

		System.out.println("Inserting 19 at end");
		myDoublyLinkList.insertLast(19);
		myDoublyLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myDoublyLinkList.deleteLast().data);
		myDoublyLinkList.displayList();
	}
}
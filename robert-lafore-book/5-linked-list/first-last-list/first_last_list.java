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

class FirstLastList {
	public Link first;
	public Link last;

	public FirstLastList() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return (first==null);
	}

	public void insertFirst(int data) { // !!!
		Link temp = new Link(data);

		if(isEmpty()) {
			temp.next = null;
			first = temp;
			last = temp;
		}
		else {
			temp.next = first;
			first = temp;
		}
	}
	public void insertLast(int data) { // !!!
		Link temp = new Link(data);

		if(isEmpty()) {
			temp.next = null;
			first = temp;
			last = temp;
		}
		else {
			// the only difference between insert first is that
			// insert first doesn't need to change original first's previous
			last.next = temp;
			
			temp.next = null;
			last = temp;
		}

	}
	public Link deleteFirst() {

		if(isEmpty()) {
			System.out.println("Error: you are trying to delete a link from an empty list.");
			return null;
		}
		else {
			Link temp = first;
			if(first.next == null) { // delete the only one link
				last = null;
				first = null;
			}
			else {
				first = first.next;
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

class FirstLastListApp {

	public static void main(String[] args) {

		FirstLastList myFirstLastList = new FirstLastList();

		System.out.println("Before inserting the first link, try print the link list.");
		myFirstLastList.displayList();

		System.out.println("Inserting 32.");
		myFirstLastList.insertFirst(32);
		myFirstLastList.displayList();

		System.out.println("Inserting 73");
		myFirstLastList.insertFirst(73);
		myFirstLastList.displayList();

		System.out.println("Inserting 93 at end");
		myFirstLastList.insertLast(93);
		myFirstLastList.displayList();

		System.out.println("Inserting 19 at end");
		myFirstLastList.insertLast(19);
		myFirstLastList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myFirstLastList.deleteFirst().data);
		myFirstLastList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myFirstLastList.deleteFirst().data);
		myFirstLastList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myFirstLastList.deleteFirst().data);
		myFirstLastList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myFirstLastList.deleteFirst().data);
		myFirstLastList.displayList();

		System.out.println("Inserting 19 at end");
		myFirstLastList.insertLast(19);
		myFirstLastList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myFirstLastList.deleteFirst().data);
		myFirstLastList.displayList();


	}
}
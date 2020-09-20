// this is the enhanced edition of the basic link list mentioned in the textbook
// it contains find(int key) and delete (int key) method
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

class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}
	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int data) {
		Link temp = new Link(data);
		temp.next = first;
		first = temp;
	}

	public Link findKey(int key) {
		Link current;

		current = first;
		if(current == null) {
			System.out.println("Warning: you are trying to search an empty link list.");
		}
		else {
			while(current != null) {
				if(current.data == key) {
					return current; // no need to use break statement
				}
				else {
					current = current.next;
				}
			}
			System.out.println("Cannot find a link with the specified key.");
		}
		return null;
	}

	public Link deleteKey(int key) {
		Link current;;
		Link previous; // it must be used in delete method

		current = first;
		previous = first;
		if(current == null) {
			System.out.println("Warning: you are trying to search an empty link list and remove a link with specified key.");
		}
		else {
			while(current != null) {

				if(current.data == key) {
					if(current == first) {
						// no need to deal with previous pointer because first does not have a previous
						first = first.next;
					}
					else {
						previous.next = current.next;
					}
					return current; // no need to use break statement
				}
				else {
					previous = current;
					current = current.next;
				}
			}
			System.out.println("Cannot find a link with the specified key.");
		}
		return null;
	}

	public Link deleteFirst() {
		Link temp = first;
		if(temp == null) {
			System.out.println("Warning: you are trying to search an empty link list and remove a link with specified key.");
		}
		else {
			first = first.next;
		}
		return temp;
	}

	public void displayList() {
		Link current = first;
		if(current == null) {
			System.out.println("Warning: you are trying to display an empty link list.");
		}
		else {
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
			System.out.println(" ");// One list for each line
		}
	}
}

class LinkListApp {
	
	public static void main(String[] args) {
		LinkList myLinkList = new LinkList();
		
		System.out.println("Before inserting the first link, try print the link list.");
		myLinkList.displayList();

		System.out.println("Inserting 32.");
		myLinkList.insertFirst(32);
		myLinkList.displayList();

		System.out.println("Inserting 73");
		myLinkList.insertFirst(73);
		myLinkList.displayList();

		System.out.println("Inserting 26");
		myLinkList.insertFirst(26);
		myLinkList.displayList();

		System.out.println("Inserting 93");
		myLinkList.insertFirst(93);
		myLinkList.displayList();

		System.out.println("Inserting 19");
		myLinkList.insertFirst(19);
		myLinkList.displayList();

		System.out.println("Inserting 102");
		myLinkList.insertFirst(102);
		myLinkList.displayList();

		System.out.println("Inserting 239");
		myLinkList.insertFirst(239);
		myLinkList.displayList();

		System.out.println("Removem the first link.");
		System.out.println("It has data "+myLinkList.deleteFirst().data);
		myLinkList.displayList();

		System.out.println("Removem the link with data 111.");
		myLinkList.deleteKey(111);
		myLinkList.displayList();

		System.out.println("Removem the link with data 26.");
		myLinkList.deleteKey(26);
		myLinkList.displayList();

		System.out.println("Removem the link with data 102.");
		myLinkList.deleteKey(102);
		myLinkList.displayList();

		System.out.println("Removem the link with data 32.");
		myLinkList.deleteKey(32);
		myLinkList.displayList();		
	}
}
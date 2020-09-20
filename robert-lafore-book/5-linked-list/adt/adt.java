// Both stack and queue are implemented in this file
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

// Enhanced by adding an "inefficient" deleteLast
class EnhancedLinkList {
	public Link first;

	public EnhancedLinkList() {
		first = null;
	}
	public boolean isEmpty() {
		return (first==null);
	}

	public void insertFirst(int data) {
		Link temp = new Link(data);
		temp.next = first;
		first = temp;
	}

	public Link deleteFirst() {
		Link temp = first;
		if(isEmpty()) {
			System.out.println("Error: you are trying to delete a link from an empty list.");
			return null;
		}
		else {
			first = temp.next;
			return temp;
		}
	}

	public Link deleteLast() {
		Link current = first;
		Link previous = first;
		if(!isEmpty()) {
			while(current.next != null) { // go to the last link
				previous = current;
				current = current.next;
			}
			previous.next = null;
			return current;	
		}
		else {
			System.out.println("Error: you are trying to delete a link from an empty list.");
			return null;
		}
		
	}

	public void displayList() {
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}

class EnhancedLinkListApp {

	public static void main(String[] args) {

		EnhancedLinkList myEnhancedLinkList = new EnhancedLinkList();

		System.out.println("Before inserting the first link, try print the link list.");
		myEnhancedLinkList.displayList();

		System.out.println("Inserting 32.");
		myEnhancedLinkList.insertFirst(32);
		myEnhancedLinkList.displayList();

		System.out.println("Inserting 73");
		myEnhancedLinkList.insertFirst(73);
		myEnhancedLinkList.displayList();

		System.out.println("Inserting 26");
		myEnhancedLinkList.insertFirst(26);
		myEnhancedLinkList.displayList();

		System.out.println("Remove first");
		System.out.println("The following link has been deleted: "+myEnhancedLinkList.deleteFirst().data);
		myEnhancedLinkList.displayList();

		System.out.println("Remove last");
		System.out.println("The following link has been deleted: "+myEnhancedLinkList.deleteLast().data);
		myEnhancedLinkList.displayList();
	}
}

////////////////
// ADT stack
////////////////
class Stack {
	EnhancedLinkList myEnhancedLinkList;
	public Stack() {
		myEnhancedLinkList = new EnhancedLinkList();
	}
	public void push(int data) {
		myEnhancedLinkList.insertFirst(data);
	}
	public Link pop() {
		if(!myEnhancedLinkList.isEmpty()) {
			return myEnhancedLinkList.deleteFirst(); // actually this is able to return null aready
			// but I created the if statement to make it clear
		}
		else {
			System.out.println("Error: you are tyring to pop an empty stack.");
			return null;
		}
	}
	public void displayStack() {
		myEnhancedLinkList.displayList();
	}
}

class StackApp {
	public static void main(String[] args) {
		Stack myStack = new Stack();

		myStack.push(5);
		myStack.displayStack();

		myStack.push(10);
		myStack.displayStack();

		myStack.push(25);
		myStack.displayStack();

		System.out.println("Popping from stack.");
		System.out.println("The following link has been popped: "+myStack.pop().data);
	}
}
////////////////
// ADT queue
////////////////
class Queue {
	EnhancedLinkList myEnhancedLinkList;
	public Queue() {
		myEnhancedLinkList = new EnhancedLinkList();
	}
	public void enqueue(int data) {
		myEnhancedLinkList.insertFirst(data);
	}
	public Link dequeue() {
		if(!myEnhancedLinkList.isEmpty()) {
			return myEnhancedLinkList.deleteLast();
		}
		else {
			System.out.println("Empty queue");
			return null;
		}
	}
	public void displayQueue() {
		myEnhancedLinkList.displayList();
	}
}
class QueueApp {
	public static void main(String[] args) {
		Queue myQueue = new Queue();

		myQueue.enqueue(5);
		myQueue.displayQueue();

		myQueue.enqueue(15);
		myQueue.displayQueue();

		myQueue.enqueue(45);
		myQueue.displayQueue();

		System.out.println("Dequeue: "+myQueue.dequeue().data);
		myQueue.displayQueue();

		System.out.println("Dequeue: "+myQueue.dequeue().data);
		myQueue.displayQueue();
	}
}
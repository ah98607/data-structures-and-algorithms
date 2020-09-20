class Node {

	int iData;
	Node leftChild;
	Node rightChild;

	public Node(int data) {
		iData = data;
	}

	public void display() {
		System.out.print("{"+iData+"}");
	}
}

class Tree {

	Node root;

	public Tree() {
		// before any insert, set tree root to null
		root = null;
	}

	public void insert(int data) {

		System.out.println("Inserting "+data+" to the BST.");

		// deal with empty tree case
		if(root == null) {
			System.out.println("The new node becomes the root.");
			root = new Node(data);
		}

		// look for proper location to put the new node
		else {

			Node current = root;
			Node previous = root; // used to store current's parent
			boolean isLeft = false;

			while(true) {
				//System.out.println("current is "+current.iData);
				if(data < current.iData) { // go to left child
					System.out.println("Making a left.");
					isLeft = true;
					if(current.leftChild != null) {
						previous = current;
						current = current.leftChild;
					}
					else {
						break;
					}
				}
				else {
					System.out.println("Making a right.");
					isLeft = false;

					if(current.rightChild != null) {
						current = current.rightChild;
					}
					else {
						break;
					}
				}
				previous = current; // save parent node before entering next iteration
			}
			current = new Node(data);
			if(isLeft) {
				previous.leftChild = current;
			}
			else {
				previous.rightChild = current;
			}
		}
		System.out.println(""); // display an empty line
	}

	public boolean remove(int data) {
		// return 1 when removing finishes
		Node current = root;
		Node previous = root;
		boolean isLeft = false;
		System.out.println("Trying to remove the node with data "+data);
		while(true) {
			if(current == null) {
				System.out.println("Cannot find the target node, exit.");
				return false;
			}
			else if(current.iData == data) {
				System.out.print("Found the node to be removed.");
				if(current == root) {
					System.out.println("Root is to be removed");
					//
				}
				else {

					// type 1: delnode has no child
					// assign its parent's *Child with null
					if(current.leftChild == null && current.rightChild == null) {
						if(isLeft == true) 
							previous.leftChild = null;
						else
							previous.rightChild = null;
					}

					// type 2: delnode has a single child
					// connect parent's *Child with delnode's single child
					else if(current.leftChild == null) { // type 2(a)
						if(isLeft == true)
							previous.leftChild = current.rightChild;
						else
							previous.rightChild = current.rightChild;
					}
					else if(current.rightChild == null) { // type 2(b)
						if(isLeft == true)
							previous.leftChild = current.leftChild;
						else
							previous.rightChild = current.leftChild;
					}

					// type 3: delnode has two children
					else { // type 3
						// assign parent's *child with delnode's successor
						Node successor = getSuccessor(current);
						if(isLeft)
							previous.leftChild = successor;
						else
							previous.rightChild = successor;

						// assign successor's leftChild with delnode's leftChild
						successor.leftChild = current.leftChild;

						// assign successor's rightCHild with delnode's rightChild (unless successor is delnode's rightChild)
						// assign successor's parent's leftChild with null (unless successor is delnode's rightChild)
						// this is done in getSuccessor()
					}
					return true;
				}
			}
			else if(data < current.iData) {
				isLeft = true;
				previous = current; // save current
				current = current.leftChild;
			}
			else {
				isLeft = false;
				previous = current;
				current = current.rightChild;
			}
		}
	}
	public void display() {
		// not implemented for now
	}
	public Node find(int data) {
		// this method shows how target node is searched
		Node current = root;
		System.out.println("Trying to find node with data "+data);
		while(true) {
			if(current == null) {
				System.out.println("Cannot find the node.");
				return null;
			}
			else if(current.iData == data) {
				System.out.println("Target node found.");
				return current;
			}
			else if(data < current.iData) {
				System.out.println("Go to left.");
				current = current.leftChild;
			}
			else {
				System.out.println("Go to right.");
				current = current.rightChild;
			}
		}
		
	}
	public void traverse(int traverseType) {
		// for now, it calls inOrder only
		switch(traverseType) {
			case 0: {
				System.out.println("Starting in-order traverse.");
				inOrder(root);
				break;
			}
			case 1: {
				System.out.println("Starting pre-order traverse.");
				//
				break;
			}
			case 2: {
				System.out.println("Starting post-order traverse.");
				//
				break;
			}
		}
	}

	// the following methods are internally called only
	private void preOrder(Node startNode) {
		// not implemented for now
	}

	// recursive in-order traverse
	private void inOrder(Node startNode) {
		//
		Node current = startNode;
		if(current == null) {
			//System.out.println("Reaching the null node, return.");
			return; // force return
		}
		else {
			inOrder(current.leftChild);
			System.out.print(current.iData+", ");
			inOrder(current.rightChild);
		}
	}
	private void postOrder(Node startNode) {
		// not implemented for now
	}
	private Node getSuccessor(Node delNode) {
		//
		Node current;
		Node previous;

		System.out.println("Starting get the successor of the node ["+delNode.iData+"].");

		if(delNode.rightChild == null) {
			System.out.println("The node to be removed does not have a successor.");
			System.out.println("This method is very likely called wrongly by 'remove' method.");
			return null;
		}
		else {
			current = delNode.rightChild; // go right first
			previous = delNode.rightChild;

			// go to successor node
			while(true) {
				if(current.leftChild != null) {
					System.out.println("Make a left.");
					previous = current; // keep track of current's parent, this MUST be done!!
					current = current.leftChild;
				}
				else {
					break;
				}
			}
			
			// special case: successor is or isn't delnode's rightChild
			if(current != delNode.rightChild) {

				// successor's parent no longer has a left child
				previous.leftChild = null;

				// successor's right child points to del node's right child
				current.rightChild = delNode.rightChild;
			}
			System.out.println("The successor of the target node is "+current.iData);
			return current;
		}
	}
	public Node getSuccessor2(Node delNode) { // this method only print the successor without changing successor's parent!
		//
		Node current;
		Node previous;

		System.out.println("Starting get the successor of the node ["+delNode.iData+"].");

		if(delNode.rightChild == null) {
			System.out.println("The node to be removed does not have a successor.");
			System.out.println("This method is probably wrongly called by 'remove' method.");
			return null;
		}
		else {
			current = delNode.rightChild; // go right first
			previous = delNode.rightChild;
			while(true) {
				if(current.leftChild != null) {
					System.out.println("Make a left.");
					previous = current; // keep track of current's parent, this MUST be done!!
					current = current.leftChild;
				}
				else {
					break;
				}
			}
			////
			////previous.leftChild = null; // this cannot be done in remove(), must be done here!!
			////
			System.out.println("The successor of the target node is "+current.iData);
			return current;
		}
	}
}
class BstApp {
	public static void main(String[] args) {
		Tree myTree = new Tree();
		
		myTree.insert(50);
		myTree.insert(11);
		myTree.insert(54);
		myTree.insert(45);
		myTree.insert(21);
		myTree.insert(82);
		myTree.insert(3);

		myTree.find(50);
		myTree.find(21);
		myTree.find(100); // test finding a non-existing node

		myTree.traverse(0); // in-order traverse

		myTree.getSuccessor2(myTree.root);
		myTree.getSuccessor2(myTree.root.leftChild); // look for successor of 11

		myTree.remove(82); // remove type 1
		System.out.print("After removing 82, the tree is :");
		myTree.traverse(0);
		myTree.insert(82); // recover
		System.out.print("After recovering 82, the tree is :");
		myTree.traverse(0);
		myTree.remove(54); // remove type 2
		System.out.print("After removing 54, the tree is :");
		myTree.traverse(0);
		myTree.remove(11); // remove type 3
		System.out.print("After removing 11, the tree is :");
		myTree.traverse(0);

	}
}
/* The tree used in the test case looks like:
		                     50
		       11                        54
	     3           45            null      82
		          21   null
*/

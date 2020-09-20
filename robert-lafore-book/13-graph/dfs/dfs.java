class Vertex {
	// vertex of the graph, like node in heaps and trees
	// remember that heap is array of nodes and tree is not array
	public char label;
	public boolean wasVisited;

	public Vertex(char c) {
		label = c;
		wasVisited = false;
	}
}

class Stack {
	// stack is used in DFS, while queue is used in BFS
	// stack stores the index of the node in graph
	
	int[] stackArray; // array used to implement the stack, we can also use link list to do this
	int top;

	public Stack(int size) {
		stackArray = new int[size];
		top = -1;
		displayStack();
	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void displayStack() {
		
		if(isEmpty()) {
			System.out.println("Warning: stack is emtpy.");
		}
		else {
			System.out.print("Stack is: ");
			for(int i=0; i<=top; i++)
				System.out.print(stackArray[i]+", ");
			System.out.println(" ");
		}
	}
}

class StackTest {
	public static void main(String[] args) {
		Stack myStack = new Stack(5);
		myStack.displayStack();
	}
}

// NOTE: also pay attention to how array is used
class Graph {
	// a combination of several vertice
	final int SIZE = 20; // max size of the graph
	Vertex[] vertexArray; // array of vertice
	int[][] adjMatrix; // 2-D array to store the info about adjacency
	Stack vertexStack; // stack instance used in DFS
	int nVert; // number of vertices that has been added, must be smaller than SIZE

	public Graph() {
		vertexArray = new Vertex[SIZE]; // note that we only create the array here, real vertex creating will be done when addVertex is called

		adjMatrix = new int[SIZE][SIZE]; // create adj matrix and initialize it
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				adjMatrix[i][j] = 0; // temporarily initialized with 0, will be assigned meaningful value when addEdge is called
			}
		}

		vertexStack = new Stack(SIZE); // create the stack work space according to the graph size
		nVert = 0;
	}

	public void addEdge(int start, int end) {
		// note we consider graph without direction
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	public void addVertex(char c) {
		vertexArray[nVert++] = new Vertex(c);
	}

	public void dfs() {
		// core code of dfs

		// start from the first vertex
		System.out.println("Insert node 'A'.");
		vertexArray[0].wasVisited = true;
		vertexStack.push(0);

		// search
		while(vertexStack.isEmpty() != true) {
			// find the next unvisited vertex of currnt vertex (current is the "top" in the stack)
			System.out.println("Current vertex in this iteration is '"+vertexStack.peek()+"'.");
			int v = getUnvisitedVertex(vertexStack.peek());

			if(v == -1) {
				// current vertex does not have a next unvisited adj vertex
				vertexStack.pop();
				System.out.println("Reached the end, go back.");
			}
			else {
				// push the next univisited adj vertex and go there
				System.out.println("Found a next unvisited adjacent vertex '"+vertexArray[v].label+"("+v+")'.");
				//displayVertex(v)
				vertexArray[v].wasVisited = true;
				vertexStack.push(v);
			}

			vertexStack.displayStack();
		}

		// restore the vertex to be "unvisited" state
		for(int i=0; i<nVert; i++) {
			vertexArray[i].wasVisited = false;
		}
	}

	public void displayVertex(int v) {
		// display the label of vertex "v"
		System.out.print(vertexArray[v].label);
	}

	public int getUnvisitedVertex(int v) {
		// find the next unvisited&&adjacent vertex of vertex "v"
		for(int i=0; i<SIZE; i++) {
			if(adjMatrix[v][i]==1 && vertexArray[i].wasVisited==false)
				return i;
		}
		return -1; // default return value indicating not found
	}
}

class GraphApp {
	// testcase for the graph DFS
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addEdge(0, 1);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(3, 4);

		myGraph.dfs();
	}
}

/*
  ----B----C
 /
A
 \
  ----D----E
*/
class Vertex {
	char label;
	boolean wasVisited;

	public Vertex(char c) {
		label = c;
		wasVisited = false;
	}
}

class Graph {
	final int SIZE = 20;
	Vertex[] vArray;
	int[][] adjMatrix;
	Queue vQueue; // the queue used by bfs
	int nVert; // vertice that has already been added

	public Graph() {
		vArray = new Vertex[SIZE];
		adjMatrix = new int[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) { // initialize adj matrix
			for(int j=0; j<SIZE; j++) {
				adjMatrix[i][j] = 0;
			}
		}
		vQueue = new Queue(SIZE);
		nVert = 0;
	}

	public void addVertex(char c) {
		vArray[nVert++] = new Vertex(c);
	}

	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	public void bfs() {
		// core code of bfs

		// set first vertex visited
		vArray[0].wasVisited = true;
		// insert its index to queue
		vQueue.insert(0);

		while(vQueue.isEmpty() != true) {
			int current = vQueue.remove();
			System.out.println("In this iteration of the out loop, current vertex is "+vArray[current].label);
			while(getNextUnvisited(current) != -1) { // walk through all of current's adjacent vertices
				int v = getNextUnvisited(current);	
				System.out.println("Found vertex"+vArray[current].label+"'s adjacent vertex "+vArray[v].label+". Insert it to queue.");
				vArray[v].wasVisited = true;
				vQueue.insert(v);
			}
		}
	}

	public int getNextUnvisited(int v) { // get the next "unvisited" && "adjacent" vertex of vertex #i
		for(int i=0; i<SIZE; i++) {
			if(adjMatrix[v][i] == 1 && vArray[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
}

class Queue { // should be enhanced by adding wrapping around
	int rear = 0;
	int front = -1;
	int[] qArray;

	public Queue(int size) {
		qArray = new int[size];
	}

	public void insert(int data) {
		qArray[rear++] = data;
	}

	public int remove() {
		return qArray[++front];
	}

	public void displayQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
		}
		else {
			System.out.print("The queue is: ");
			for(int i=front+1; i<rear; i++) {
				System.out.print(qArray[i]+", ");
			}
			System.out.println("");
		}
	}

	public boolean isEmpty() {
		return (front+1==rear);
	}
}

// test case for the queue
// note that it does not test boundry crossing!!
class QueueApp {
	public static void main(String[] args) {
		Queue myQueue = new Queue(20);
		myQueue.displayQueue();
		myQueue.insert(2);
		myQueue.displayQueue();
		myQueue.insert(5);
		myQueue.displayQueue();
		myQueue.insert(3);
		myQueue.displayQueue();
		System.out.println("Removing "+myQueue.remove());
		myQueue.displayQueue();
		System.out.println("Removing "+myQueue.remove());
		myQueue.displayQueue();
		System.out.println("Removing "+myQueue.remove());
		myQueue.displayQueue();
	}
}

class BfsApp {
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
		myGraph.bfs();
	}
}

/*
  ----B----C
 /
A
 \
  ----D----E
*/
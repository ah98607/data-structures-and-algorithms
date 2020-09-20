class Vertex {
	public char label;
	public boolean isInTree;
	public Vertex(char c) {
		label = c;
		isInTree = false;
	}
}

// there is no edge class in BFS, but it is required in weighed graph programs
// so that complete information about the edge (start, end, length) can be recorded
class Edge {
	public int srcVert;
	public int destVert;
	public int distance;

	public Edge(int sv, int dv, int dist) {
		srcVert = sv;
		destVert = dv;
		distance = dist;
	}
}

class Graph {
	final int SIZE = 20;
	Vertex[] vArray;
	int[][] adjMatrix; // adjacency matrix, note it it different because the element is no longer 0/1
	PQueue eQueue; // priority queue of edges
	int nVert; // current number of vertices that has already been added

	// below are variables that are not present in dfs/bfs/topo
	final int INFINITY = 9999;

	public Graph() {
		vArray = new Vertex[SIZE];
		adjMatrix = new int[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				adjMatrix[i][j] = INFINITY;
			}
		}
		eQueue = new PQueue();
		nVert = 0;
	}

	public void addVertex(char c) {
		//System.out.println("#"+nVert+" vertex ("+c+") is added.");
		vArray[nVert++] = new Vertex(c);
	}

	public void addEdge(int start, int end, int distance) { // note it is non-direction weighted graph
		adjMatrix[start][end] = distance;
		adjMatrix[end][start] = distance;
	}

	public void mstw() {

		// start from vertex 0
		int currentVert = 0;
		int nTree = 0;

		// note the exiting condition is not nTree<nVert
		// this is because, for graph with 3 vertices
		// we only need 2 edges to create the MST
		// therefore, only 2 iterations are needed.
		// nTree increases from 0 to 1 (1<(3-1)
		while(nTree<nVert-1) { // loop until all vertices are put into the tree
			
			System.out.println("Moving to vertex "+vArray[currentVert].label+" and add it to tree.");
			vArray[currentVert].isInTree = true; // mark it as in the tree
			nTree++;

			eQueue.displayQueue(); // debug only: see what equeue looks like in this iteration

			// find its non_self&&adjacent&&not_in_the_tree vertex and the corresponding edge
			for(int i=0; i<nVert; i++) {
				if(i==currentVert) {
					continue; // self
				}
				if(vArray[i].isInTree == true) {
					continue; // already in the tree
				}
				if(adjMatrix[currentVert][i] == INFINITY) {
					continue; // un-adjacent
				}
				System.out.println("Trying to add edge from "+vArray[currentVert].label+" to "+vArray[i].label+".");

				// put edge (from currentVert to vertex "i" by distance xxx)
				putInPQ(currentVert, i, adjMatrix[currentVert][i]);
			} // end for

			if(eQueue.isEmpty()) {
				System.out.println("Warning: edge priority queue is empty.");
			}
			else {
				Edge newShortestEdge = eQueue.removeMin();
				int newSrc = newShortestEdge.srcVert;
				int newDest = newShortestEdge.destVert;
				//System.out.println("Edge added is from "+vArray[newSrc].label+" to "+vArray[newDest].label+".");
				System.out.println("Edge removed is from "+vArray[newSrc].label+" to "+vArray[newDest].label+".");
				currentVert = newDest;
			}
			System.out.println("");
		} // end while

		// restore isInTree flag
		for(int i=0; i<nVert; i++) {
			vArray[i].isInTree = false;
		}
	}

	// put an edge that connects to "destination" by length "distance"
	public void putInPQ(int src, int dest, int dist) {

		// see if there is already an edge with the same destination
		// note that existingDestID is the index in the queue, not the index in the vArray
		int existingDestID = eQueue.find(dest);

		// if so, get its ID in eQueue
		if(existingDestID != -1) {
			System.out.println("An existing edge with vertex "+vArray[eQueue.eArray[existingDestID].destVert].label+" as its destination has been found.");
			Edge existingEdge = eQueue.peekN(existingDestID);

			// compare exisitng edge and the currently explorered edge
			if(existingEdge.distance > dist) {
				// old distance is larger, we can remove it
				eQueue.removeN(existingDestID);
			}
		}
		eQueue.insert(new Edge(src, dest, dist));
		System.out.println("Edge is added: from "+vArray[src].label+" to "+vArray[dest].label+", distance "+dist);
	}
}

// priority queue of edges
// notice we use normal queue to store index of vertex in BFS
// remember how we use priority queue in earlier chapters
// this is very similar to insert method in ordered array
// but PQueue is a little bit special, because smallest one is the last one, and removeMin returns thte last one
class PQueue {
	Edge[] eArray;
	final int SIZE = 20; // allocate 20 spots
	int size; // spots used

	public PQueue() {
		eArray = new Edge[SIZE];
		size = 0;
	}

	public void insert(Edge e) {

		int current = size; // currently, it points to eArray[size] (empty at this moment)

		while(current>0 && e.distance>eArray[current-1].distance) {
			eArray[current] = eArray[current - 1];
			current--;
		}
		eArray[current] = e;
		size++;
	}

	public Edge removeMin() {
		if(isEmpty()) {
			System.out.println("Warning: priority queue is empty.");
			return null;
		}
		else {
			return eArray[--size];
		}
	}

	public Edge peekMin() {
		return eArray[size];
	}

	// find the index of edge in eArray with specified destination vertex
	public int find(int dest) {
		for(int i=0; i<size; i++) {
			if(eArray[i].destVert == dest) {
				return i;
			}
		}
		return -1;
	}

	// remove the nth edge in eArray
	public Edge removeN(int n) {
		if(isEmpty()) {
			System.out.println("Warning: priority queue is empty.");
			return null;
		}
		else {
			Edge temp = eArray[n];
			for(int i=n; n<size-1; n++) {
				eArray[n] = eArray[n+1];
			}
			size--;
			return temp;
		}
	}

	// return the nth edge in eArray
	public Edge peekN(int n) {
		return eArray[n];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void displayQueue() { // debug only
		if(isEmpty()) {
			System.out.println("Warning: empty queue.");
		}
		else {
			System.out.print("Priority queue of size "+size+" is now (number shown is edge length): ");
			for(int i=0; i<size; i++) {
				System.out.print(eArray[i].distance+", ");
			}
			System.out.println("");
		}
	}
}

class PQueueApp { // debug only
	public static void main(String[] args) {
		Edge tempEdge;
		PQueue myQueue = new PQueue();
		myQueue.displayQueue();
		
		tempEdge = new Edge(1, 1, 1);
		myQueue.insert(tempEdge);
		myQueue.displayQueue();

		tempEdge = new Edge(1, 1, 2);
		myQueue.insert(tempEdge);
		myQueue.displayQueue();

		tempEdge = new Edge(1, 1, 4);
		myQueue.insert(tempEdge);
		myQueue.displayQueue();

		tempEdge = new Edge(1, 1, 3);
		myQueue.insert(tempEdge);
		myQueue.displayQueue();

		tempEdge = new Edge(1, 1, 9);
		myQueue.insert(tempEdge);
		myQueue.displayQueue();

		/*myQueue.removeMin();
		myQueue.displayQueue();

		myQueue.removeMin();
		myQueue.displayQueue();

		myQueue.removeMin();
		myQueue.displayQueue();*/

		myQueue.removeN(3);
		myQueue.displayQueue();
	}
}

class MstwApp {
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addVertex('F');
		myGraph.addEdge(0, 1, 6);
		myGraph.addEdge(0, 3, 4);
		myGraph.addEdge(1, 2, 10);
		myGraph.addEdge(1, 3, 7);
		myGraph.addEdge(1, 4, 7);
		myGraph.addEdge(2, 3, 8);
		myGraph.addEdge(2, 4, 5);
		myGraph.addEdge(2, 5, 6);
		myGraph.addEdge(3, 4, 12);
		myGraph.addEdge(4, 5, 7);
		myGraph.mstw();
	}
}
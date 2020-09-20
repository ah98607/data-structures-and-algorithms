class Vertex {
	public char label;
	public boolean isInTree;

	public Vertex(char c) {
		label = c;
		isInTree = false;
	}
}

class Graph {
	final int SIZE = 20;
	Vertex[] vArray;
	int[][] adjMatrix;
	int nVert;

	DistPar[] sPath;
	final int INFINITY = 9999;
	int currentVert; // must be declared here, because both mstdw and adjustSPath use it
	int startToCurrent;  // must be declared here, because both mstdw and adjustSPath use it

	public Graph() {
		vArray = new Vertex[SIZE];
		nVert = 0;
		adjMatrix = new int[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				adjMatrix[i][j] = INFINITY;
			}
		}
		sPath = new DistPar[20];
	}

	public void addVertex(char c) {
		vArray[nVert++] = new Vertex(c);
	}

	public void addEdge(int start, int end, int length) { // note it's a directed weighed graph
		adjMatrix[start][end] = length;
	}

	public void mstdw() {

		// start from vertex 0
		int nTree = 0;
		currentVert = 0;

		// step 1: transfer adjMatrix to initial sPath array (vertex 0 to its adjacent vertices )
		for(int i=0; i<nVert; i++) {
			sPath[i] = new DistPar(adjMatrix[currentVert][i], currentVert);
		}

		// display current sPath (debug only)
		displaySPath();

		// step 2: start loop
		// for similar reason in MSTW program, upper bound of nTree is nVert-1
		while(nTree < nVert-1) {

			// 2a: get the destVert with the minimum distance from vertex 0 from sPath array
			int indexMin = getMin();
			startToCurrent = sPath[indexMin].distance;

			// 2b: if the minnimum distance is not INFINITY
			if(startToCurrent != INFINITY) {
				// go to that vertex
				currentVert = indexMin;
				System.out.println("Go to vertex '"+vArray[currentVert].label+"'."); // debug only
				// mark it as in the tree
				vArray[currentVert].isInTree = true;
				// adjust sPath array
				adjust_sPath();
				// increase nTree
				nTree++;
			}
			else {
				System.out.println("Warning: found unreachable vertex '"+vArray[indexMin].label+"'.");
				break;
			}

			displaySPath();
		}
	}

	public void adjust_sPath() {
		// re calculate the distance from vertex to current vertex
		// and decide if sArray element shoud be updated

		int currentToFringe;
		int newStartToFringe;

		for(int i=1; i<nVert; i++) {
			if(!vArray[i].isInTree) {
				currentToFringe = adjMatrix[currentVert][i]; // vertex "i" is "Fringe"
				newStartToFringe = startToCurrent + currentToFringe;
				if(sPath[i].distance > newStartToFringe) {
					sPath[i].distance = newStartToFringe;
					sPath[i].parentIndex = currentVert;
				}
			}
		}
	}

	public void displaySPath() { // debug only
		System.out.print("sPath: ");
		for(int j=0; j<nVert; j++) {
			System.out.print("'"+vArray[j].label+"' = "+sPath[j].distance+" ("+vArray[sPath[j].parentIndex].label+"), ");
		}
		System.out.println("");
	}

	public int getMin() {
		// return the next unvisited destVertex index with minimum distance from vertex 0 from sPath array
		int tempMinDist = INFINITY;
		int tempVertID = 0;
		for(int i=1; i<nVert; i++) { // note that we start from i = 1
			if(sPath[i].distance<tempMinDist && !vArray[i].isInTree) {
				tempMinDist = sPath[i].distance;
				tempVertID = i;
			}
		}
		return tempVertID;
	}
}

class DistPar {
	// this class is a helper class that stores distance/parent pair
	// just like the edge priority queue we used in last program

	int distance;
	int parentIndex;
	
	public DistPar(int dist, int parent) {
		distance = dist;
		parentIndex = parent;
	}
}

class DjikstraApp {
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addEdge(0, 1, 50);
		myGraph.addEdge(0, 3, 80);
		myGraph.addEdge(1, 2, 60);
		myGraph.addEdge(1, 3, 90);
		myGraph.addEdge(2, 4, 40);
		myGraph.addEdge(3, 2, 20);
		myGraph.addEdge(3, 4, 70);
		myGraph.addEdge(4, 1, 50);
		myGraph.mstdw();
	}
}
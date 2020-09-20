// wasVisited is not needed in topo
class Vertex {
	char label;
	public Vertex(char c) {
		label = c;
	}
}

class Graph {
	Vertex[] vArray;
	int[][] adjMatrix;
	int nVert;
	final int SIZE = 20;

	public Graph() {
		vArray = new Vertex[SIZE];
		adjMatrix = new int[SIZE][SIZE];
		nVert = 0;

		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}

	public void addVertex(char c) {
		vArray[nVert++] = new Vertex(c);
	}

	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1; // note that edge has direction
	}

	public void topo() {

		// nVert is going to decrease
		// so we need to keep a copy of the total number of vertices
		final int NUM_VERT = nVert;
		// store the index of new "ending" vertex
		int newEnd;
		// vertex array to store removed vertex
		Vertex[] workSpace = new Vertex[NUM_VERT];

		while(nVert > 0) {

			System.out.println("In this iteration, there are "+nVert+" vertices.");

			// find a vertex that is endding vertex but not starting vertex
			newEnd = noSuccessor();

			if(newEnd == -1) {
				System.out.println("Warning: cannot find new end.");
			}
			else {
				// store removed vertex, pay attention to the index
				workSpace[nVert-1] = vArray[newEnd];

				// remove it from the vArray and put it in temp array
				for(int i=newEnd; i<nVert-1; i++) {
					System.out.println(vArray[i].label+" is replaced with "+vArray[i+1].label+".");
					vArray[i] = vArray[i+1];
				}

				// adjust the adjMatrix
				// my implementation is different from the textbook
				// 1. move columns left
				for(int i=newEnd; i<nVert; i++) {
					for(int j=0; j<nVert; j++) {
						adjMatrix[i][j] = adjMatrix[i+1][j];
					}
				}

				// 2. move rows up, notice the current row number
				for(int i=0; i<nVert-1; i++) { // after step 1, horizontal index is 1 smaller
					for(int j=newEnd; j<nVert; j++) {
						adjMatrix[i][j] = adjMatrix[i][j+1];
					}
				}

				// reduce nVert
				nVert--;

				// print verte array for debug purpose
				System.out.print("After this iteration, vertex array: ");
				for(int i=0; i<nVert; i++) {
					System.out.print(vArray[i].label+", ");
				}
				System.out.println("");
			}
		}

		System.out.println("===============================");
		System.out.print("Topo sorting finished. Topo sequence: ");
		for(int i=0; i<NUM_VERT; i++) {
			System.out.print(workSpace[i].label);
		}
		System.out.println("");
		System.out.println("===============================");
	}

	// find a vertex that has no successor (cannot be a starting vertext of another vertex)
	// my implementation is a little bit different from the textbook, which uses "break" in the internal loop
	public int noSuccessor() {
		boolean isStartVertex;
		for(int i=0; i<nVert; i++) {
			isStartVertex = false;
			for(int j=0; j<nVert; j++) {
				if(adjMatrix[i][j] == 1) {
					// edge from "i" to "j" found
					// vertex "i" does not qualify
					isStartVertex =true;
				}
			}
			if(!isStartVertex) {
				// vertex "i" is not a start vertex of any edge, return it
				System.out.println("Return "+i+" (vertex '"+vArray[i].label+"').");
				return i;
			}
		}
		return -1; // final default return value indivating cannot find it
	}
}

class TopoApp {
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex('A');
		myGraph.addVertex('B');
		myGraph.addVertex('C');
		myGraph.addVertex('D');
		myGraph.addVertex('E');
		myGraph.addVertex('F');
		myGraph.addVertex('G');
		myGraph.addVertex('H');
		myGraph.addEdge(0, 3);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(2, 5);
		myGraph.addEdge(3, 6);
		myGraph.addEdge(4, 6);
		myGraph.addEdge(5, 7);
		myGraph.addEdge(6, 7);

		//System.out.println(myGraph.noSuccessor()); // this is to test noSuccessor() method
		myGraph.topo();
	}
}
/*
A -- D \
  \     \
   \    / G\
B--- E /    \
             \H
             /
            /
        C--F
*/
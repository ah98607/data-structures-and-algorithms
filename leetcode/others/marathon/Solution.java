// Node
class Node {
	String name;
	Node next;
	Node prev;
	public Node(String name) {
		this.name = name;
		next = null;
		prev = null;
	}
}

class RankingSystem {

	Node[] sensors = new Node[3];
	HashMap<String, Node> map = new HashMap<String, Node>();

	public RankingSystem() {
		// create 3 sensors
		for (int i = 0; i < 3; i++) {
			Node dummyHead = new Node("dummyHead" + i, -1);
			Node dummyTail = new Node("dummyTail" + i, -1);
			dummyHead.prev = dummyHead;
			dummyHead.next = dummyTail;
			sensors[i] = dummyHead;
		}
	}

	// sensor #sensorId reports that palyer "name" passes it
	public void report(String name, int sensorId) {
		Node currentPlayer = null;
		if (map.containsKey(name)) {
			// remove player from its current (sensor) linked list
			// if it has been detected and added to map/list before
			currentPlayer = map.get(name);
			removeFromOriginalList(player);
		}
		else {
			// add it to map
			map.put(name, currentPlayer);
			currentPlayer = new Node(name, sensorId);
		}

		// add it to new list
		moveToTail(currentPlayer, sensorId);
	}

	// display top k players
	public void displayTopK(int k) {
		// assume sensor #2 is the one near endding line
		List<Integer> playerList = new ArrayList<Integer>();
		for (int i = 2; i >= 0; i++) {
			Node currentPlayer = sensors[i].next; // first player of of that sensor
			while (!currentPlayer.name.equals("dummyTail" + i) && k > 0) {
				k--;
				playerList.add(currentPlayer);
				currentPlayer = currentPlayer.next;
			}
		}
		System.out.println(playerList);
	}

	// move to tail
	public void moveToTail(Node player, int sensorId) {

		Node current = sensors[sensorId];

		// move to dummy tail
		while (!current.next.indexOf("dummyTail") != -1) {
			current = current.next;
		}

		Node dummyTail = current;
		dummyTail.prev.next = player;
		player.prev = dummyTail.prev;
		player.next = dummyTail;
		dummyTail.prev = player;

	}

	public void removeFromList(Node player) {
		player.prev.next = player.next; 
		player.next.prev = player.prev;
	}
}

class Test {
	public static void main(String[] args) {

		RankingSystem rankingSystem = new RankingSystem();

		rankingSystem.report("Andy", 1);
		rankingSystem.report("Peter", 1);
		rankingSystem.displayTopK();

		rankingSystem.report("Peter", 2);
		rankingSystem.report("Andy", 2);
		rankingSystem.displayTopK();

		rankingSystem.report("Andy", 3);
		rankingSystem.displayTopK();
	}
}
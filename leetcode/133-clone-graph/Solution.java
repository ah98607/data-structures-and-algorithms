/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> q = new LinkedList<Node>();
        Set<Node> vis = new HashSet<Node>();
        q.offer(node);
        vis.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            map.put(temp, new Node(temp.val));
            for (Node neighbor : temp.neighbors) {
                if (!vis.contains(neighbor)) {
                    vis.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();
            for (Node neighbor : oldNode.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
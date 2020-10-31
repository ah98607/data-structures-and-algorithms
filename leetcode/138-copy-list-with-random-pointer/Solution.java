/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            if (prev != null) {
                map.get(prev).next = map.get(cur);
            }
            prev = cur;
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
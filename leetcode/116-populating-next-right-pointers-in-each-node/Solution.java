/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        recFind(root.left, root, null);
        recFind(root.right, root, null);
        return root;
    }
    private void recFind(Node node, Node parent, Node uncle) {
        if (node == null) {
            return;
        }
        if (node == parent.left) {
            node.next = parent.right;
            recFind(node.left, node, parent.right);
            recFind(node.right, node, parent.right);
        }
        else {
            if (uncle != null) {
                node.next = uncle.left;
                recFind(node.left, node, uncle.left);
                recFind(node.right, node, uncle.left);
            }
            else {
                recFind(node.left, node, null);
                recFind(node.right, node, null);
            }
        }
    }
}
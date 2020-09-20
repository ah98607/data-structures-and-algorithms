/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        if (root.children.isEmpty()) {
            return newNode;
        }
        TreeNode current = newNode;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode child = encode(root.children.get(i));
            if (i == 0) {
                current.left = child;
                current = current.left;
            }
            else {
                current.right = child;
                current = current.right;
            }
        }
        return newNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Node> children = new ArrayList<Node>();
        TreeNode current = root.left;
        while (current != null) {
            children.add(decode(current));
            current = current.right;
        }
        return new Node(root.val, children);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return sHelper(root, new StringBuilder()).toString();
    }
    private StringBuilder sHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
            return sb;
        }
        sb.append(node.val).append(",");
        sHelper(node.left, sb).append(",");
        sHelper(node.right, sb);
        return sb;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>();
        int start = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ',') {
                q.offer(data.substring(start, i));
                start = i + 1;
            }
        }
        q.offer(data.substring(start, data.length()));
        return dHelper(q);
    }
    private TreeNode dHelper(Queue<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        String temp = q.poll();
        if (temp.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(temp));
        node.left = dHelper(q);
        node.right = dHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
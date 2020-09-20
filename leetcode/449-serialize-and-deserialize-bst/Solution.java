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
    private StringBuilder sHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return sb;
        }
        sb.append(root.val).append(",");
        sHelper(root.left, sb).append(",");
        sHelper(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sArray = data.split(",");
        Queue<String> q = new LinkedList<String>();
        for (int i = 0; i < sArray.length; i++) {
            q.offer(sArray[i]);
        }
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
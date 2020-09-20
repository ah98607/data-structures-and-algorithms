/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        Map<TreeNode, TreeNode> n2p = new HashMap<TreeNode, TreeNode>();
        Set<Integer> keysRemoved = new HashSet<Integer>();
        for (int i = 0; i < to_delete.length; i++) {
            keysRemoved.add(to_delete[i]);
        }
        recFind(root, null, n2p);
        if (!keysRemoved.contains(root.val)) {
            res.add(root);
        }
        for (Map.Entry<TreeNode, TreeNode> entry : n2p.entrySet()) {
            if (keysRemoved.contains(entry.getKey().val)) {
                TreeNode node = entry.getKey();
                TreeNode parent = entry.getValue();
                if (parent != null) {
                    if (node == parent.left) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                    }
                }
                if (node.left != null && !keysRemoved.contains(node.left.val)) {
                    res.add(entry.getKey().left);
                }
                if (node.right != null && !keysRemoved.contains(node.right.val)) {
                    res.add(entry.getKey().right);
                }
            }
        }
        return res;
    }
    private void recFind(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> n2p) {
        if (node == null) {
            return;
        }
        n2p.put(node, parent);
        recFind(node.left, node, n2p);
        recFind(node.right, node, n2p);
    }
}
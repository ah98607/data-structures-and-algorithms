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
        if (root == null) {
            return res;
        }
        Set<Integer> dels = new HashSet<Integer>();
        for (int i = 0; i < to_delete.length; i++) {
            dels.add(to_delete[i]);
        }
        Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        recFind(root, parents, null);
        if (!dels.contains(root.val)) {
            res.add(root);
        }
        for (Map.Entry<TreeNode, TreeNode> entry : parents.entrySet()) {
            if (dels.contains(entry.getKey().val)) {
                if (entry.getValue() != null) {
                    if (entry.getKey() == entry.getValue().left) {
                        entry.getValue().left = null;
                    }
                    else {
                        entry.getValue().right = null;
                    }
                }
                if (entry.getKey().left != null && !dels.contains(entry.getKey().left.val)) {
                    res.add(entry.getKey().left);
                }
                if (entry.getKey().right != null && !dels.contains(entry.getKey().right.val)) {
                    res.add(entry.getKey().right);
                }
            }
        }
        return res;
    }
    private void recFind(TreeNode node, Map<TreeNode, TreeNode> parents, TreeNode parent) {
        if (node == null) {
            return;
        }
        parents.put(node, parent);
        recFind(node.left, parents, node);
        recFind(node.right, parents, node);
    }
}
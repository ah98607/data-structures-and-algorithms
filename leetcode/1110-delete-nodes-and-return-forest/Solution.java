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
        Set<Integer> numsDel = new HashSet<Integer>();
        for (int i = 0; i < to_delete.length; i++) {
            numsDel.add(to_delete[i]);
        }
        Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        recFind(root, null, parents);
        if (!numsDel.contains(root.val)) {
            res.add(root);
        }
        for (Map.Entry<TreeNode, TreeNode> entry : parents.entrySet()) {
            TreeNode node = entry.getKey();
            if (numsDel.contains(node.val)) {
                TreeNode parent = entry.getValue();
                if (parent != null) {
                    if (node == parent.left) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                    }
                }
                if (node.left != null && !numsDel.contains(node.left.val)) {
                    res.add(node.left);
                }
                if (node.right != null && !numsDel.contains(node.right.val)) {
                    res.add(node.right);
                }
            }
        }
        return res;
    }
    private void recFind(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null) {
            return;
        }
        parents.put(node, parent);
        recFind(node.left, node, parents);
        recFind(node.right, node, parents);
    }
}
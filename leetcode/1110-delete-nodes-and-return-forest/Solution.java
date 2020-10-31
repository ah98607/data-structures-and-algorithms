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
        Set<Integer> dels = new HashSet<Integer>();
        for (int i = 0; i < to_delete.length; i++) {
            dels.add(to_delete[i]);
        }
        Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        Set<TreeNode> delNodes = new HashSet<TreeNode>();
        recFind(root, null, parents, dels, delNodes);
        if (!dels.contains(root.val)) {
            res.add(root);
        }
        for (TreeNode delNode : delNodes) {
            if (parents.get(delNode) != null) {
                TreeNode parent = parents.get(delNode);
                if (delNode == parent.left) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            if (delNode.left != null && !delNodes.contains(delNode.left)) {
                res.add(delNode.left);
            }
            if (delNode.right != null && !delNodes.contains(delNode.right)) {
                res.add(delNode.right);
            }
        }
        return res;
    }
    private void recFind(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents, Set<Integer> dels, Set<TreeNode> delNodes) {
        if (node == null) {
            return;
        }
        if (!parents.containsKey(node)) {
            parents.put(node, parent);
        }
        if (dels.contains(node.val)) {
            delNodes.add(node);
        }
        recFind(node.left, node, parents, dels, delNodes);
        recFind(node.right, node, parents, dels, delNodes);
    }
}
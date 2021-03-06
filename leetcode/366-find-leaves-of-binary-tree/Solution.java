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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        recFind(res, 0, root);
        return res;
    }
    private int recFind(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) {
            return -1;
        }
        int maxDepth = 1 + Math.max(recFind(res, level + 1, node.left), recFind(res, level + 1, node.right));
        if (maxDepth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(maxDepth).add(node.val);
        return maxDepth;
    }
}
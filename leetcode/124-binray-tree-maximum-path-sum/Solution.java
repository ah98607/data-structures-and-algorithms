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
    int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = Integer.MIN_VALUE;
        recFind(root);
        return res;
    }
    private int recFind(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftRes = recFind(node.left);
        int rightRes = recFind(node.right);
        res = Math.max(res, node.val + Math.max(leftRes, 0) + Math.max(rightRes, 0));
        return node.val + Math.max(0, Math.max(leftRes, rightRes));
    }
}
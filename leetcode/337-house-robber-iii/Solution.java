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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = recFind(root);
        return Math.max(res[0], res[1]);
    }
    private int[] recFind(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] leftRes = recFind(node.left);
        int[] rightRes = recFind(node.right);
        res[0] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        res[1] = node.val + leftRes[0] + rightRes[0];
        return res;
    }
}
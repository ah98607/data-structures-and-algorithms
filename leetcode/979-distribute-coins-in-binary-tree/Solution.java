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
    int moves;
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recFind(root);
        return moves;
    }
    private int recFind(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftRes = recFind(node.left);
        int rightRes = recFind(node.right);
        moves += Math.abs(leftRes) + Math.abs(rightRes);
        return node.val - 1 + leftRes + rightRes;
    }
}
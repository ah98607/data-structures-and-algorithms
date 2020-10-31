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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recFind(root.left, root.right);
    }
    private boolean recFind(TreeNode n1, TreeNode n2) {
        return n1 == null && n2 == null || n1 != null && n2 != null && n1.val == n2.val && recFind(n1.left, n2.right) && recFind(n1.right, n2.left);
    }
}
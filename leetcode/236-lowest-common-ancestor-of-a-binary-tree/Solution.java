/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes != null && rightRes != null) {
            return root;
        }
        if (leftRes != null) {
            return leftRes;
        }
        return rightRes;
    }
}
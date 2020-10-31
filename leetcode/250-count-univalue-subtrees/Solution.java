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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recFind(root);
        return res;
    }
    private boolean recFind(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean leftRes = recFind(node.left);
        boolean rightRes = recFind(node.right);
        if (node.left == null && node.right == null) {
            res++;
            return true;
        }
        else if (node.left != null & node.right != null) {
            if (node.val == node.left.val && node.val == node.right.val && leftRes && rightRes) {
                res++;
                return true;
            }
        }
        else if (node.left != null) {
            if (node.val == node.left.val && leftRes) {
                res++;
                return true;
            }
        }
        else {
            if (node.val == node.right.val && rightRes) {
                res++;
                return true;
            }
        }
        return false;
    }
}
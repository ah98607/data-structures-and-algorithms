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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null) {
            parent = current;
            if (val < current.val) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        if (parent == null) {
            return node;
        }
        if (val < parent.val) {
            parent.left = node;
        }
        else {
            parent.right = node;
        }
        return root;
    }
}
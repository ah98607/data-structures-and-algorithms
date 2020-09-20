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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode lCur = root;
        TreeNode rCur = root;
        int y = 0;
        while (lCur != null && rCur != null) {
            lCur = lCur.left;
            rCur = rCur.right;
            y++;
        }
        if (lCur == null && rCur == null) {
            return (int) Math.pow(2, y) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode prev = null;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp != null) {
                if (temp != root && prev == null) {
                    return false;
                }
                q.offer(temp.left);
                q.offer(temp.right);
            }
            prev = temp;
        }
        return true;
    }
}
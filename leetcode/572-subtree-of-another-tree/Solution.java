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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val == t.val && sameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean sameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 != null && n2 != null && n1.val == n2.val && sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right)) {
            return true;
        }
        return false;
    }
}
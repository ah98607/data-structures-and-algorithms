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
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recFind(0, root);
        return sum;
    }
    private void recFind(int num, TreeNode node) {
        if (node == null) {
            return;
        }
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += num;
        }
        recFind(num, node.left);
        recFind(num, node.right);
    }
}
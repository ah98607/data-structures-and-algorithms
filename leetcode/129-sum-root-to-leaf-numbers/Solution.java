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
        recFind(root, 0);
        return sum;
    }
    private void recFind(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += num;
        }
        recFind(node.left, num);
        recFind(node.right, num);
    }
}
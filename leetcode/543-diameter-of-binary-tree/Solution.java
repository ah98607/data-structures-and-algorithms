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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recFind(root);
        return result;
    }
    private int recFind(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftResult = recFind(root.left);
        int rightResult = recFind(root.right);
        result = Math.max(result, leftResult + rightResult);
        return 1 + Math.max(leftResult, rightResult);
    }
}
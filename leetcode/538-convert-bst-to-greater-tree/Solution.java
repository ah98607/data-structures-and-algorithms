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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        int total = getSum(root);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int prevSum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int temp = cur.val;
            cur.val = total - prevSum;
            prevSum += temp;
            cur = cur.right;
        }
        return root;
    }
    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        return sum + getSum(node.left) + getSum(node.right);
    }
}
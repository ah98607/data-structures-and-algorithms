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
        int sum = recFind(root);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int preSum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int temp = cur.val;
            cur.val = sum - preSum;
            preSum += temp;
            cur = cur.right;
        }
        return root;
    }
    private int recFind(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        sum += recFind(node.left);
        sum += recFind(node.right);
        return sum;
    }
}
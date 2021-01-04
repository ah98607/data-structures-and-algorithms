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
        int total = recFind(root);
        int prevSum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
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
    private int recFind(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + recFind(node.left) + recFind(node.right);
    }
}
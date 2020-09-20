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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        stack.push(root);
        vis.add(root);
        int sum = 0;
        int num = root.val;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !vis.contains(temp.left)) {
                stack.push(temp.left);
                vis.add(temp.left);
                num = num * 10 + temp.left.val;
            }
            else if (temp.right != null && !vis.contains(temp.right)) {
                stack.push(temp.right);
                vis.add(temp.right);
                num = num * 10 + temp.right.val;
            }
            else {
                if (temp.left == null && temp.right == null) {
                    sum += num;
                }
                num = (num - stack.pop().val) / 10;
            }
        }
        return sum;
    }
}
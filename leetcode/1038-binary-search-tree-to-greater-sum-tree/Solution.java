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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int sum = 0;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            sum += current.val;
            current = current.right;
        }
        current = root;
        int prevSum = 0;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            int temp = current.val;
            current.val = sum - prevSum;
            prevSum += temp;
            current = current.right;
        }
        return root;
    }
}
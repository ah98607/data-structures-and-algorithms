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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);
        visited.add(root);
        int pathSum = root.val;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !visited.contains(temp.left)) {
                stack.push(temp.left);
                visited.add(temp.left);
                pathSum += temp.left.val;
            }
            else if (temp.right != null && !visited.contains(temp.right)) {
                stack.push(temp.right);
                visited.add(temp.right);
                pathSum += temp.right.val;
            }
            else {
                if (temp.left == null && temp.right == null && pathSum == sum) {
                    return true;
                }
                pathSum -= stack.pop().val;
            }
        }
        return false;
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        stack.push(root);
        vis.add(root);
        res.add(root.val);
        int level = 0;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.right != null && !vis.contains(temp.right)) {
                stack.push(temp.right);
                vis.add(temp.right);
                level++;
                if (level >= res.size()) {
                    res.add(temp.right.val);
                }
            }
            else if (temp.left != null && !vis.contains(temp.left)) {
                stack.push(temp.left);
                vis.add(temp.left);
                level++;
                if (level >= res.size()) {
                    res.add(temp.left.val);
                }
            }
            else {
                stack.pop();
                level--;
            }
        }
        return res;
    }
}
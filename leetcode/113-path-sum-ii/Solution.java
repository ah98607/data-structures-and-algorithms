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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        List<Integer> iList = new ArrayList<Integer>();
        stack.push(root);
        vis.add(root);
        iList.add(root.val);
        int mySum = root.val;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !vis.contains(temp.left)) {
                stack.push(temp.left);
                vis.add(temp.left);
                mySum += temp.left.val;
                iList.add(temp.left.val);
            }
            else if (temp.right != null && !vis.contains(temp.right)) {
                stack.push(temp.right);
                vis.add(temp.right);
                mySum += temp.right.val;
                iList.add(temp.right.val);
            }
            else {
                if (temp.left == null && temp.right == null && mySum == sum) {
                    res.add(new ArrayList<Integer>(iList));
                }
                mySum -= stack.pop().val;
                iList.remove(iList.size() - 1);
            }
        }
        return res;
    }
}
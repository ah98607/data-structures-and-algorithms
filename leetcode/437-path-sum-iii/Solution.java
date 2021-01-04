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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        List<Integer> prevSum = new ArrayList<Integer>();
        stack.push(root);
        vis.add(root);
        prevSum.add(root.val);
        if (root.val == sum) {
            res++;
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !vis.contains(temp.left)) {
                vis.add(temp.left);
                stack.push(temp.left);
                prevSum.add(prevSum.get(prevSum.size() - 1) + temp.left.val);
                if (prevSum.get(prevSum.size() - 1) == sum) {
                    res++;
                }
                for (int i = 0; i < prevSum.size() - 1; i++) {
                    if (prevSum.get(prevSum.size() - 1) - prevSum.get(i) == sum) {
                        res++;
                    }
                }
            }
            else if (temp.right != null && !vis.contains(temp.right)) {
                vis.add(temp.right);
                stack.push(temp.right);
                prevSum.add(prevSum.get(prevSum.size() - 1) + temp.right.val);
                if (prevSum.get(prevSum.size() - 1) == sum) {
                    res++;
                }
                for (int i = 0; i < prevSum.size() - 1; i++) {
                    if (prevSum.get(prevSum.size() - 1) - prevSum.get(i) == sum) {
                        res++;
                    }
                }
            }
            else {
                stack.pop();
                prevSum.remove(prevSum.size() - 1);
            }
        }
        return res;
    }
}
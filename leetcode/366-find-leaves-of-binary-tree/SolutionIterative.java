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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Set<TreeNode> rm = new HashSet<TreeNode>();
        while (!rm.contains(root)) {
            Set<TreeNode> tempRm = new HashSet<TreeNode>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            Set<TreeNode> vis = new HashSet<TreeNode>();
            stack.push(root);
            vis.add(root);
            while (!stack.isEmpty()) {
                TreeNode temp = stack.peek();
                if (temp.left != null && !vis.contains(temp.left) && !rm.contains(temp.left)) {
                    stack.push(temp.left);
                    vis.add((temp.left));
                }
                else if (temp.right != null && !vis.contains(temp.right) && !rm.contains(temp.right)) {
                    stack.push(temp.right);
                    vis.add((temp.right));
                }
                else {
                    if ((temp.left == null || rm.contains(temp.left)) && (temp.right == null || rm.contains(temp.right))) {
                        tempRm.add(temp);
                    }
                    stack.pop();
                }
            }
            List<Integer> iList = new ArrayList<Integer>();
            for (TreeNode node : tempRm) {
                iList.add(node.val);
                rm.add(node);
            }
            res.add(iList);
        }
        return res;
    }
}
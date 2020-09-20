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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        List<Integer> iList = new ArrayList<Integer>();
        stack.push(root);
        vis.add(root);
        iList.add(root.val);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !vis.contains(temp.left)) {
                stack.push(temp.left);
                vis.add(temp.left);
                iList.add(temp.left.val);
            }
            else if (temp.right != null && !vis.contains(temp.right)) {
                stack.push(temp.right);
                vis.add(temp.right);
                iList.add(temp.right.val);
            }
            else {
                if (temp.left == null && temp.right == null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < iList.size(); i++) {
                        sb.append(i == 0 ? iList.get(i) : ("->" + iList.get(i)));
                    }
                    res.add(sb.toString());
                }
                stack.pop();
                iList.remove(iList.size() - 1);
            }
        }
        return res;
    }
}
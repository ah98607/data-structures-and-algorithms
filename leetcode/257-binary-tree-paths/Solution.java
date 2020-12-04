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
        recFind(res, "", root);
        return res;
    }
    private void recFind(List<String> res, String s, TreeNode node) {
        if (node == null) {
            return;
        }
        s += (s.length() == 0 ? "" : "->") + node.val;
        if (node.left == null && node.right == null) {
            res.add(s);
        }
        recFind(res, s, node.left);
        recFind(res, s, node.right);
    }
}
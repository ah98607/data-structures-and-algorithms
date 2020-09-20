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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            boolean added = false;
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                if (!added) {
                    res.add(temp.val);
                    added = true;
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }
            }
        }
        return res;
    }
}
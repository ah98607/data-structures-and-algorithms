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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            double levelSum = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                levelSum += temp.val;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null)
                    q.offer(temp.right);
                }
            res.add(levelSum / qSize);
        }
        return res;
    }
}
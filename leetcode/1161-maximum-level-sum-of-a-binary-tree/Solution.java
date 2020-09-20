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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int res = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            int levelSum = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                levelSum += temp.val;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
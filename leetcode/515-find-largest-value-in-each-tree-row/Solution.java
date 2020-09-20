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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                rowMax = Math.max(rowMax, temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            result.add(rowMax);
        }
        return result;
    }
}
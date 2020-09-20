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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> iList = new ArrayList<Integer>();
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.poll();
                iList.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            if ((level & 1) == 1) {
                Collections.reverse(iList);
            }
            res.add(iList);
            level++;
        }
        return res;
    }
}
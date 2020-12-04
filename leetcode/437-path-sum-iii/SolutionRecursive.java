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
    int res;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        recFind(root, sum, new ArrayList<Integer>());
        return res;
    }
    private void recFind(TreeNode node, int sum, List<Integer> iList) {
        if (node == null) {
            return;
        }
        iList.add(iList.size() == 0 ? node.val : (iList.get(iList.size() - 1) + node.val));
        if (iList.get(iList.size() - 1) == sum) {
            res++;
        }
        for (int i = 0; i < iList.size() - 1; i++) {
            if (iList.get(iList.size() - 1) - iList.get(i) == sum) {
                res++;
            }
        }
        recFind(node.left, sum, new ArrayList<Integer>(iList));
        recFind(node.right, sum, new ArrayList<Integer>(iList));
    }
}
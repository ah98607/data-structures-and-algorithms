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
        recFind(new ArrayList<Integer>(), root, sum);
        return res;
    }
    private void recFind(List<Integer> iList, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        iList.add(iList.isEmpty() ? node.val : node.val + iList.get(iList.size() - 1));
        if (iList.get(iList.size() - 1) == sum) {
            res++;
        }
        for (int i = 0; i < iList.size() - 1; i++) {
            if (iList.get(iList.size() - 1) - iList.get(i) == sum) {
                res++;
            }
        }
        recFind(new ArrayList<Integer>(iList), node.left, sum);
        recFind(new ArrayList<Integer>(iList), node.right, sum);
    }
}
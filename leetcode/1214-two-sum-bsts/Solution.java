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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        recFind(root1, set);
        return recFind(root2, set, target);
    }
    private void recFind(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        recFind(node.left, set);
        recFind(node.right, set);
    }
    private boolean recFind(TreeNode node, Set<Integer> set, int target) {
        if (node == null) {
            return false;
        }
        if (set.contains(target - node.val)) {
            return true;
        }
        return recFind(node.left, set, target) || recFind(node.right, set, target);
    }
}
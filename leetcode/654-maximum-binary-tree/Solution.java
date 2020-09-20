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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return recFind(nums, 0, nums.length - 1);
    }
    private TreeNode recFind(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = recFind(nums, left, maxIndex - 1);
        node.right = recFind(nums, maxIndex + 1, right);
        return node;
    }
}
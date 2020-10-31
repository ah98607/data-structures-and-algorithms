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
    public TreeNode bstFromPreorder(int[] preorder) {
        return recFind(preorder, 0, preorder.length - 1);
    }
    private TreeNode recFind(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(nums[left]);
        int index = left + 1;
        while (index <= right && nums[index] < nums[left]) {
            index++;
        }
        node.left = recFind(nums, left + 1, index - 1);
        node.right = recFind(nums, index, right);
        return node;
    }
}
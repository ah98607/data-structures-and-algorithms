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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recFind(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode recFind(int[] pre, int pl, int pr, int[] in, int il, int ir, Map<Integer, Integer> map) {
        if (pl > pr) {
            return null;
        }
        TreeNode node = new TreeNode(pre[pl]);
        int index = map.get(pre[pl]);
        node.left = recFind(pre, pl + 1, pl + index - il, in, il, index - 1, map);
        node.right = recFind(pre, pl + index - il + 1, pr, in, index + 1, ir, map);
        return node;
    }
}
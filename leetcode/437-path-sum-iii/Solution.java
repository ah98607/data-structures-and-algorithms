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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        List<Integer> iList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> vis = new HashSet<TreeNode>();
        stack.push(root);
        vis.add(root);
        iList.add(root.val);
        int res = 0;
        if (iList.get(0) == sum) {
            res++;
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null && !vis.contains(temp.left)) {
                stack.push(temp.left);
                vis.add(temp.left);
                iList.add(temp.left.val + iList.get(iList.size() - 1));
                if (iList.get(iList.size() - 1) == sum) {
                    res++;
                }
                for (int i = 0; i < iList.size() - 1; i++) {
                    if (iList.get(iList.size() - 1) - iList.get(i) == sum) {
                        res++;
                    }
                }
            }
            else if (temp.right != null && !vis.contains(temp.right)) {
                stack.push(temp.right);
                vis.add(temp.right);
                iList.add(temp.right.val + iList.get(iList.size() - 1));
                if (iList.get(iList.size() - 1) == sum) {
                    res++;
                }
                for (int i = 0; i < iList.size() - 1; i++) {
                    if (iList.get(iList.size() - 1) - iList.get(i) == sum) {
                        res++;
                    }
                }
            }
            else {
                stack.pop();
                iList.remove(iList.size() - 1);
            }
        }
        return res;
    }
}
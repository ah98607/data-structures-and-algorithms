/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> nStack = new Stack<TreeNode>();
        HashMap<TreeNode, Integer> isVisited = new HashMap<TreeNode, Integer>();
        int currentSum = root.val;
        int maxSum = currentSum;
        nStack.push(root);
        isVisited.put(root, 1);
        while (!nStack.isEmpty()) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            TreeNode temp = nStack.peek();
            if (temp.left != null && isVisited.get(temp.left) == null) {
                nStack.push(temp.left);
                isVisited.put(temp.left, 1);
                currentSum += temp.left.val;
            }
            else if (temp.right != null && isVisited.get(temp.right) == null) {
                nStack.push(temp.right);
                isVisited.put(temp.right, 1);
                currentSum += temp.right.val;
            }
            else {
                // reach a leaf node
                currentSum -= nStack.pop().val;
            }
        }
        return maxSum;
    }
}
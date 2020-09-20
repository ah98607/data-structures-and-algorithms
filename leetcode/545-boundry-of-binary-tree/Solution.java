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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        HashSet<TreeNode> isAdded = new HashSet<TreeNode>();
        addLeft(root, result, isAdded); // add root and left side (1, 2)
        addBottom(root, result, isAdded); // add bottom except for bottom-left (4, 7, 8, 9 , 10)
        addRight(root, result, isAdded); // add right side (6, 3)
        return result;
    }
    private void addLeft(TreeNode root, List<Integer> result, HashSet<TreeNode> isAdded) {
        TreeNode current = root;
        boolean isLeftChildOfRoot = false;
        while (current != null) {
            result.add(current.val);
            isAdded.add(current);
            if (current.left != null) {
                current = current.left;
                isLeftChildOfRoot = true;
            }
            else if (isLeftChildOfRoot) {
                current = current.right;
            }
            else {
                current = null;
            }
        }
    }
    private void addBottom(TreeNode root, List<Integer> result, HashSet<TreeNode> isAdded) {
        Stack<TreeNode> nStack = new Stack<TreeNode>();
        HashSet<TreeNode> isVisited = new HashSet<TreeNode>();
        nStack.push(root);
        isVisited.add(root);
        while (!nStack.isEmpty()) {
            TreeNode temp = nStack.peek();
            if (temp.left != null && !isVisited.contains(temp.left)) {
                nStack.push(temp.left);
                isVisited.add(temp.left);
            }
            else if (temp.right != null && !isVisited.contains(temp.right)) {
                nStack.push(temp.right);
                isVisited.add(temp.right);
            }
            else {
                if (temp.left == null && temp.right == null) {
                    if (!isAdded.contains(temp)) {
                        result.add(temp.val);
                        isAdded.add(temp);
                    }
                }
                nStack.pop();
            }
        }
    }
    private void addRight(TreeNode root, List<Integer> result, HashSet<TreeNode> isAdded) {
        TreeNode current = root;
        boolean isRightChildOfRoot = false;
        List<Integer> localResult = new ArrayList<Integer>();
        while (current != null) {
            if (!isAdded.contains(current)) {
                localResult.add(current.val);
                isAdded.add(current);
            }
            if (current.right != null) {
                current = current.right;
                isRightChildOfRoot = true;
            }
            else if (isRightChildOfRoot) {
                current = current.left;
            }
            else {
                current = null;
            }
            
        }
        for (int i = 0; i < localResult.size(); i++) {
            result.add(localResult.get(localResult.size() - 1 - i));
        }
    }
}
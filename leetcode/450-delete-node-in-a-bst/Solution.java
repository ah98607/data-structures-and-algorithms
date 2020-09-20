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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode parent = null;
        TreeNode toDelete = null;
        while (current != null) {
            if (key == current.val) {
                toDelete = current;
                break;
            }
            parent = current;
            if (key < current.val) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        if (toDelete == null) {
            return root;
        }
        if (toDelete.left == null && toDelete.right == null) {
            if (toDelete == root) {
                return null;
            }
            else {
                if (toDelete == parent.left) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
        }
        else if (toDelete.left != null && toDelete.right != null) {
            TreeNode successorOfNodeDeleted = getSuccessor(toDelete);
            successorOfNodeDeleted.left = toDelete.left;
            if (toDelete == root) {
                root = successorOfNodeDeleted;
            }
            else {
                if (toDelete == parent.left) {
                    parent.left = successorOfNodeDeleted;
                }
                else {
                    parent.right = successorOfNodeDeleted;
                }
            }
        }
        else {
            if (toDelete == root) {
                root = toDelete.left != null ? toDelete.left : toDelete.right;
            }
            else {
                if (toDelete == parent.left) {
                    parent.left = toDelete.left != null ? toDelete.left : toDelete.right;
                }
                else {
                    parent.right = toDelete.left != null ? toDelete.left : toDelete.right;
                }
            }
            
        }
        return root;
    }
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.right;
        TreeNode parent = node;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        if (current != node.right) {
            parent.left = current.right;
            current.right = node.right;
        }
        return current;
    }
}
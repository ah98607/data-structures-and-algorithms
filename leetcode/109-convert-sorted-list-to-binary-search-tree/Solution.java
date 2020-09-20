/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        if (slowPrev != null) {
            slowPrev.next = null;
            node.left = sortedListToBST(head);
        }
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
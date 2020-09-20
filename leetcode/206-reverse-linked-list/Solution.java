/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /* iterative
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
        */
        recFind(head);
        return newHead;
    }
    private ListNode recFind(ListNode node) {
        if (node.next == null) {
            newHead = node;
            return node;
        }
        ListNode temp = recFind(node.next);
        node.next = null;
        temp.next = node;
        return node;
    }
}
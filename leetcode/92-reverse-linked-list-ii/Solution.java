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
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode nodeA = null;
        ListNode nodeAPrev = null;
        for (int i = 0; i < n; i++) {
            if (i < m) {
                nodeA = cur;
                nodeAPrev = prev;
                prev = cur;
                cur = cur.next;
            }
            else if (i < n) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
        }
        if (nodeAPrev != null) {
            nodeAPrev.next = prev;
        }
        else {
            head = prev;
        }
        nodeA.next = cur;
        return head;
    }
}
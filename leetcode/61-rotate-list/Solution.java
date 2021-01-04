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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        prev.next = head;
        cur = head;
        k = len - k;
        for (int i = 0; i < k; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        return cur;
    }
}
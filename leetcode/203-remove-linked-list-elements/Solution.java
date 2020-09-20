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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.val == val) {
                if (prev != null) {
                    prev.next = cur.next;
                }
                else {
                    head = cur.next;
                }
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
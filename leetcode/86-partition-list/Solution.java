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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode headA = null;
        ListNode prevA = null;
        ListNode headB = null;
        ListNode prevB = null;
        while (cur != null) {
            if (cur.val < x) {
                if (prevA != null) {
                    prevA.next = cur;
                }
                else {
                    headA = cur;
                }
                prevA = cur;
            }
            else {
                if (prevB != null) {
                    prevB.next = cur;
                }
                else {
                    headB = cur;
                }
                prevB = cur;
            }
            cur = cur.next;
        }
        if (prevB != null) {
            prevB.next = null;
        }
        if (prevA != null) {
            prevA.next = headB;
            return headA;
        }
        return headB;
    }
}
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next.next;
        int index = 2;
        ListNode evenPrev = head;
        ListNode oddPrev = head.next;
        ListNode oddHead = head.next;
        while (cur != null) {
            if ((index & 1) == 0) {
                evenPrev.next = cur;
                evenPrev = cur;
            }
            else {
                oddPrev.next = cur;
                oddPrev = cur;
            }
            cur = cur.next;
            index++;
        }
        oddPrev.next = null;
        evenPrev.next = oddHead;
        return head;
    }
}
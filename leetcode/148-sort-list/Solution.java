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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        slowPrev.next = null; // no need to check slowPrev
        return merge(sortList(head), sortList(slow));
    }
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode cur1 = n1;
        ListNode cur2 = n2;
        ListNode head = null;
        ListNode prev = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                if (prev != null) {
                    prev.next = cur1;
                }
                else {
                    head = cur1;
                }
                prev = cur1;
                cur1 = cur1.next;
            }
            else {
                if (prev != null) {
                    prev.next = cur2;
                }
                else {
                    head = cur2;
                }
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            prev.next = cur1;
        }
        if (cur2 != null) {
            prev.next = cur2;
        }
        return head;
    }
}
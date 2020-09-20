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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        if (fast != null) {
            slowPrev = slow;
            slow = slow.next;
        }
        slowPrev.next = null; // no need to check slowPrev
        ListNode cur1 = head;
        ListNode cur2 = reverse(slow);
        while (cur1 != null && cur2 != null) {
            ListNode temp1 = cur1.next;
            ListNode temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
    }
    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
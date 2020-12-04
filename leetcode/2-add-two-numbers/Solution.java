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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode prev = null;
        int cout = 0;
        while (cur1 != null && cur2 != null) {
            int temp = cout + cur1.val + cur2.val;
            ListNode node = new ListNode(temp % 10);
            cout = temp / 10;
            if (prev != null) {
                prev.next = node;
            }
            else {
                head = node;
            }
            prev = node;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int temp = cout + cur1.val;
            ListNode node = new ListNode(temp % 10);
            cout = temp / 10;
            if (prev != null) {
                prev.next = node;
            }
            else {
                head = node;
            }
            prev = node;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int temp = cout + cur2.val;
            ListNode node = new ListNode(temp % 10);
            cout = temp / 10;
            if (prev != null) {
                prev.next = node;
            }
            else {
                head = node;
            }
            prev = node;
            cur2 = cur2.next;
        }
        if (cout == 1) {
            prev.next = new ListNode(1);
        }
        return head;
    }
}
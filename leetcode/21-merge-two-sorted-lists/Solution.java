/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode prev = null;
        ListNode current1 = l1;
        ListNode current2 = l2;
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                if (prev != null) {
                    prev.next = current1;
                }
                else {
                    head = current1;
                }
                prev = current1;
                current1 = current1.next;
            }
            else {
                if (prev != null) {
                    prev.next = current2;
                }
                else {
                    head = current2;
                }
                prev = current2;
                current2 = current2.next;
            }
        }
        if (current1 != null) {
            prev.next = current1;
        }
        if (current2 != null) {
            prev.next = current2;
        }
        return head;
    }
}
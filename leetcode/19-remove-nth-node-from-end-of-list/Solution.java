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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curA = head;
        for (int i = 0; i < n; i++) {
            curA = curA.next;
        }
        ListNode curB = head;
        ListNode prevB = null;
        while (curA != null) {
            curA = curA.next;
            prevB = curB;
            curB = curB.next;
        }
        if (prevB != null) {
            prevB.next = curB.next;
        }
        else {
            head = curB.next;
        }
        return head;
    }
}
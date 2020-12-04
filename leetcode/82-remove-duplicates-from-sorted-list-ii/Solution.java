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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dHead = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = dHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int dupVal = cur.val;
                cur = cur.next.next;
                while (cur != null && cur.val == dupVal) {
                    cur = cur.next;
                }
                prev.next = cur;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dHead.next;
    }
}
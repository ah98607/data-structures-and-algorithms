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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oCur = head.next;
        ListNode oPrev = head;
        while (oCur != null) {
            if (oCur.val < oPrev.val) {
                ListNode iCur = head;
                ListNode iPrev = null;
                while (iCur != oCur && iCur.val <= oCur.val) {
                    iPrev = iCur;
                    iCur = iCur.next;
                }
                oPrev.next = oCur.next;
                ListNode temp = oCur.next;
                if (iPrev != null) {
                    iPrev.next = oCur;
                }
                else {
                    head = oCur;
                }
                oCur.next = iCur;
                oCur = temp;
            }
            else {
                oPrev = oCur;
                oCur = oCur.next;
            }
        }
        return head;
    }
}
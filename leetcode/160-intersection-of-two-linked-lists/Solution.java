/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        ListNode curA = headA;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode curB = headB;
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        }
        else {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
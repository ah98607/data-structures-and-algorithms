/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        int len1 = 0;
        int len2 = 0;
        // count length
        while (current1 != null) {
            current1 = current1.next;
            len1++;
        }
        while (current2 != null) {
            current2 = current2.next;
            len2++;
        }
        // go to beginning of common bits and add
        current1 = l1;
        current2 = l2;
        ListNode prev1 = null;
        ListNode prev2 = null;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                prev1 = current1;
                current1 = current1.next;
            }
            int cout = recAdd(current1, current2);
            int finalCout = recCout(l1, prev1, cout);
            if (finalCout == 1) {
                ListNode newHead = new ListNode(1);
                newHead.next = l1;
                return newHead;
            }
            else {
                return l1;
            }
        }
        else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                prev2 = current2;
                current2 = current2.next;
            }
            int cout = recAdd(current2, current1);
            int finalCout = recCout(l2, prev2, cout);
            if (finalCout == 1) {
                ListNode newHead = new ListNode(1);
                newHead.next = l2;
                return newHead;
            }
            else {
                return l2;
            }
        }
        else {
            int finalCout = recAdd(current1, current2);
            if (finalCout == 1) {
                ListNode newHead = new ListNode(1);
                newHead.next = l1;
                return newHead;
            }
            else {
                return l1;
            }
        }
    }
    private int recAdd(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return 0;
        }
        int tempSum = n1.val + n2.val + recAdd(n1.next, n2.next);
        n1.val = tempSum % 10;
        return tempSum / 10;
    }
    private int recCout(ListNode node, ListNode prev1, int cout) {
        if (node == prev1) {
            int tempSum = node.val + cout;
            node.val = tempSum % 10;
            return tempSum / 10;
        }
        int tempSum = node.val + recCout(node.next, prev1, cout);
        node.val = tempSum % 10;
        return tempSum / 10;
    }
}
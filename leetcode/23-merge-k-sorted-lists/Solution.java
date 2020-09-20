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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode head = null;
        ListNode prev = null;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (prev != null) {
                prev.next = temp;
            }
            else {
                head = temp;
            }
            if (temp.next != null) {
                pq.offer(temp.next);
            }
            prev = temp;
        }
        return head;
    }
}
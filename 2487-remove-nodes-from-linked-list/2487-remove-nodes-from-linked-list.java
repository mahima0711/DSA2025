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

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        // Step 1: reverse
        ListNode rev = reverse(head);

        // Step 2: keep nodes that are >= max so far
        int max = rev.val;
        ListNode curr = rev;

        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; // delete
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }

        // Step 3: reverse back
        return reverse(rev);

    }
}
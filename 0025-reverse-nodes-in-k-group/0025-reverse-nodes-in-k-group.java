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
    public ListNode reverseKGroup(ListNode head, int k) {

         if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKthNode(groupPrev.next, k);
            if (kth == null)
                break;

            ListNode nextGroup = kth.next;

            ListNode curr = groupPrev.next;
            ListNode prev = nextGroup;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode tempTail = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tempTail;
        }
     return dummy.next;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) { // move k-1 steps
            node = node.next;
            k--;
        }
        return node; // will be null if fewer than k nodes
    }

}
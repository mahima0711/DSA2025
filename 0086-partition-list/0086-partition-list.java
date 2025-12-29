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
    public ListNode partition(ListNode head, int x) {

        ListNode firstHalf = new ListNode(0);
        ListNode secondHalf = new ListNode(0);;

        ListNode curr = head;

        ListNode t1 = firstHalf;
        ListNode t2 = secondHalf;
        while (curr != null) {
            if (curr.val < x) {
                firstHalf.next = curr;
                firstHalf = firstHalf.next;
            }
            else
            {
                 secondHalf.next = curr;
                secondHalf = secondHalf.next; 
            }

            curr = curr.next;
        }

        secondHalf.next =null;

        firstHalf.next = t2.next;

        return t1.next;
    }
}
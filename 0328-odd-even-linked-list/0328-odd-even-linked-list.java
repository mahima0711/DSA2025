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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode firstHalf = new ListNode(0);
        ListNode secondHalf = new ListNode(0);;

        ListNode curr = head;
        int count=1;

        ListNode t1 = firstHalf;
        ListNode t2 = secondHalf;
        while (curr != null) {
            if (count %2 !=0) {
                firstHalf.next = curr;
                firstHalf = firstHalf.next;
            }
            else
            {
                 secondHalf.next = curr;
                secondHalf = secondHalf.next; 
            }
            
            curr = curr.next;
            count++;
        }

        secondHalf.next =null;

        firstHalf.next = t2.next;

        return t1.next;
    }
}
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        int pos=1;

        ListNode t =head;
        ListNode before = null;

        if(left == right)
           return head;

        while(pos<left)
        {
           before = t;
           t =t.next;
           pos++;
           continue;
        }

        ListNode curr = t;
        ListNode prev =null;
        int times = right -left +1;


        while(times >0)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr =temp;
            times--;
        }

       // Connect tail of reversed part to remaining list
        t.next = curr;

        // Connect before-left to new head of reversed part
        if (before != null) {
            before.next = prev;
            return head;        // head unchanged
        }

        // If left == 1 → new head is prev
        return prev;

    }
}
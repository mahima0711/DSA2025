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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode fast = head;
        int count =0;

        while(fast!=null)
        {
         count++;
         fast =fast.next;
        }

        fast = head;
        ListNode newNode = null;
        int k = count-n;

        if(k == 0) return head.next;

        for(int i=0;i<k;i++)
        {
            newNode = fast;
            fast = fast.next;
        }

        newNode.next = fast.next;

        fast =null;
        return head;
    }
}
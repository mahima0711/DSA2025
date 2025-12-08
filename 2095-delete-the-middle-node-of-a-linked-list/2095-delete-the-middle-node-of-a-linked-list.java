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
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode fast = head;
        ListNode dummyNode = new ListNode(0,head);
        ListNode slow = dummyNode;

        while(fast!=null&& fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.next!=null)
        {
            slow.next = slow.next.next;
        }

        return dummyNode.next;
    }
}
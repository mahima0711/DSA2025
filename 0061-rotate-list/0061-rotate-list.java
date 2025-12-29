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
    public ListNode rotateRight(ListNode head, int k) {
        
         if (head == null || head.next == null || k == 0)
            return head;
        ListNode curr =head;;
        int length=0;
        while(curr !=null)
        {
          length++;
          curr = curr.next;
        }
        curr = head;

        k = k % length;
        if (k == 0) return head;

        int move = (length -k) % length;

        if(move <0)
        {
            move = move+length;
        }

        System.out.println(move);

        while(move>1)
        {
            curr = curr.next;
            move--;
        }

        ListNode temp = curr.next;
        ListNode ans = temp;
        curr.next = null;

        while(temp.next !=null)
        {
            temp =temp.next;
        }

        temp.next = head;

        return ans;

    }
}
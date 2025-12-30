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
    public ListNode[] splitListToParts(ListNode head, int k) {
        

        ListNode[] ans = new ListNode[k];
        ListNode curr = head;

        int length =0;

        while(curr !=null)
        {
            length++;
            curr = curr.next;
        }

        curr=head;
        int base = length/k;
        int extra = length%k;

        for(int i=0;i<k;i++)
        {

            if(curr == null)
            {
                ans[i] = null;
                continue;
            }

            ans[i] =curr;

            int part = base + (extra > 0 ? 1 :0);

            extra--;

            for(int j=1; j< part ;j++)
            {
                curr =curr.next;
            }

            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }


        return ans;

    }
}
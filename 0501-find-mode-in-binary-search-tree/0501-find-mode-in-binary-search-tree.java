/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int currNum =0;
    int currFreq = 0;
    int maxFreq = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        
        calculate(root);

        int[] ans = new int[list.size()];

        for(int i=0;i<list.size();i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }

    void calculate(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        calculate(node.left);

        if(node.val != currNum)
        {
            currNum = node.val;
            currFreq = 1;
        }
        else
        {
            currFreq++;
        }

        if(currFreq == maxFreq)
        {
            list.add(node.val);
        }

        if(currFreq > maxFreq)
        {
            maxFreq = currFreq;
            list.clear();
            list.add(node.val);
        }

        calculate(node.right);
    }
}
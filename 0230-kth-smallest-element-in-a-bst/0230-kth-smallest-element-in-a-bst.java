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

    int kth =0;

    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
        {
            return 0;
        }

        find(root, k);

        return kth;
    }

    void find(TreeNode root, int k)
    {
        if(root == null)
        {
            return;
        }

        find(root.left, k);

        count++;

        if(count == k)
        {
            kth = root.val;
            return;
        }

        find(root.right, k);

    }
}
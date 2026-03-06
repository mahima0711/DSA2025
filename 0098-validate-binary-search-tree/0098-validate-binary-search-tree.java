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

    TreeNode prev = null;

    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        if(root == null)
        {
            return ans;
        }
        validate(root);

        return ans;
    }

    void validate(TreeNode node)
    {
        if(node == null)
        {
            return;
        }

        validate(node.left);

        if(prev != null)
        {
            if(node.val <= prev.val)
            {
                ans = false;
            }
        }

        prev = node;

        validate(node.right);

    }
}
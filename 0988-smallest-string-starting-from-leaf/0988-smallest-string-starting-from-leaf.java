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

    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        
        if(root == null)
          return null;

        check(root, "");

        return ans;
    }

    void check(TreeNode node, String str)
    {
        if(node == null)
        {
            return;
        }

        char c = (char) ('a' + node.val);

        str = c + str;

        if(node.left == null && node.right == null)
        {
            if(str.compareTo(ans) < 0)
                ans = str;
        }

        check(node.left, str);

        check(node.right, str);

    }
}
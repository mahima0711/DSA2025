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
    int maxLevel =0;
    public int maxDepth(TreeNode root) {

        if(root == null)
          return maxLevel;

        traverse(root, 1);

        return maxLevel;
    }

    void traverse(TreeNode node, int level)
    {
        if(node == null)
        {
            return;
        }
        maxLevel = Math.max(level, maxLevel);

        traverse(node.left, level+1);
        traverse(node.right, level+1);

    }
}
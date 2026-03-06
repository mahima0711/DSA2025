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

    int diff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }

        getMin(root);

        return diff;
    }

    void getMin(TreeNode root) {
        if (root == null) {
            return;
        }

        getMin(root.left);

        if (prev != null) {
            int minDiff = Math.abs(root.val - prev.val);

            diff = Math.min(diff, minDiff);
        }

        prev = root;

        getMin(root.right);
    }
}
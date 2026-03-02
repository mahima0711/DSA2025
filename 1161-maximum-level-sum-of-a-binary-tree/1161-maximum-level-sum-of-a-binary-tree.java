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
    public int maxLevelSum(TreeNode root) {

        int ans = 0;

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int m = Integer.MIN_VALUE;

        int currLevel = 0;

        while(!queue.isEmpty())
        {
            int level = queue.size();

            int sum = 0;
            currLevel += 1;
            for(int i=0;i<level;i++)
            {
                TreeNode node = queue.poll();

                sum = sum + node.val;

                if(node.left != null)
                   queue.offer(node.left);

                if(node.right != null)
                   queue.offer(node.right);
                
            }

            if(sum > m)
            {
                m =sum;
                ans = currLevel;
            }

        }

        return ans;
    }
}
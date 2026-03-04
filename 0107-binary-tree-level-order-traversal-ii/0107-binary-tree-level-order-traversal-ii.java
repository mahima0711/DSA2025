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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
         return ans;

        queue.offer(root);

        while(!queue.isEmpty())
        {
            int level = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<level;i++)
            {

                TreeNode node = queue.peek();

                if(node.left != null)
                {
                    queue.offer(node.left);
                }

                if(node.right != null)
                {
                    queue.offer(node.right);
                }

                list.add(node.val);

                queue.poll();
            }

            ans.add(0,list);
        }

        return ans;
    }
}
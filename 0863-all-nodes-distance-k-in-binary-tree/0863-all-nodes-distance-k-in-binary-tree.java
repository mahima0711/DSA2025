/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    void inorder(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        inorder(map, root.left);


        if (root.right != null) {
            map.put(root.right, root);
        }

        inorder(map, root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> map = new HashMap<>();

        inorder(map, root);

        List<Integer> ans = new ArrayList<>();

        check(root, target, k, map, ans);

        return ans;
    }

    void check(TreeNode root, TreeNode target, int k, Map<TreeNode, TreeNode> map, List<Integer> ans) {

        Queue<TreeNode> queue = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);

        visited.add(target);


        while(!queue.isEmpty())
        {

            int n = queue.size();

            if(k == 0 )
            {
                break;
            }

            for(int i=0; i<n; i++)
            {
                TreeNode node = queue.poll();
                //left
                if(node.left != null && !visited.contains(node.left))
                {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                //right
                if(node.right != null && !visited.contains(node.right))
                {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                //parent
                if(map.containsKey(node) && !visited.contains(map.get(node)))
                {
                    queue.offer(map.get(node));
                    visited.add(map.get(node));
                }
            }

            k--;
        }


        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            ans.add(node.val);
        }
    }
}
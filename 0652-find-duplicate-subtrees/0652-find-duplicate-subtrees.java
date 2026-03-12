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

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        if(root == null)
        {
            return ans;
        }

        findDup(root);

        return ans;
    }

    String findDup(TreeNode root)
    {
        if(root == null)
        {
            return "N";
        }

        String s = String.valueOf(root.val) +", " + findDup(root.left) +", "+ findDup(root.right);

        if(map.containsKey(s) && map.get(s) == 1)
        {
            ans.add(root);
        }

        map.put(s, map.getOrDefault(s, 0)+1);

        return s;
    }
}
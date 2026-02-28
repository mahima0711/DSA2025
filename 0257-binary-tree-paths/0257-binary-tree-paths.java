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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        path(root, list, str);

        return list;
    }

    void path(TreeNode root, List<String> list, StringBuilder str)
    {
        if(root == null)
        {
          return;
        }

        int len = str.length(); 

        if(root.left == null && root.right == null)
        {
            str.append(root.val);
            list.add(str.toString());
            str.setLength(len);
            return;
        }

        str.append(root.val);
        str.append("->");

        path(root.left, list, str);
        path(root.right, list, str);

        str.setLength(len);
    }
}
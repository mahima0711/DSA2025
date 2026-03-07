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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        create(root, list);

        return attach(list, 0, list.size()-1);
    }

    TreeNode attach(List<Integer> list, int low, int high)
    {
        if(low > high)
        {
            return null;
        }

        int mid = (low+high)/2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = attach(list, low , mid-1);
        root.right = attach(list, mid+1, high);

        return root;
    }

    void create(TreeNode node, List<Integer> list)
    {
        if(node == null)
        {
            return;
        }  

        create(node.left , list);

        list.add(node.val);

        create(node.right, list);
    }
}
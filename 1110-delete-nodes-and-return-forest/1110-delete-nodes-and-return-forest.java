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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = new HashSet<>();
        ArrayList<TreeNode> arr = new ArrayList<>();

        for (int num : to_delete) {
            set.add(num);
        }

        deleteHelper(root, set, arr);

        if (!set.contains(root.val)) {
            arr.add(root);
        }

        return arr;
    }

    private TreeNode deleteHelper(TreeNode root, Set<Integer> set, ArrayList<TreeNode> arr) {
        if (root == null)
            return null;

        root.left = deleteHelper(root.left, set, arr);
        root.right = deleteHelper(root.right, set, arr);

        if (set.contains(root.val)) {
            if (root.left != null) {
                arr.add(root.left);
            }
            if (root.right != null) {
                arr.add(root.right);
            }

            return null;
        } else {
            return root;
        }

    }
}
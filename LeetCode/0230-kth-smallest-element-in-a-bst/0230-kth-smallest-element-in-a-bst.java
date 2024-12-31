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
    private List<Integer> tmp = new ArrayList<>(); 

    public int kthSmallest(TreeNode root, int k) {
        this.inorder(root);

        return tmp.get(k - 1);
    }

    private void inorder(TreeNode tree) {
        if (tree == null) return;

        inorder(tree.left);
        tmp.add(tree.val);
        inorder(tree.right);
    }
}
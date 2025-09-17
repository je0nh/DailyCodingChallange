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
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return this.inorder(root);
    }

    private boolean inorder(TreeNode tree) {
        if (tree == null) return true;

        if (!inorder(tree.left)) return false;

        if (prev != null && prev >= tree.val) return false;
        prev = tree.val;

        return inorder(tree.right);
    }
}
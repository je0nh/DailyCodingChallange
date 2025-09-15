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
    private int idx = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    private Integer inorder(TreeNode tree, int k) {
        if (tree == null) return null;

        Integer left = inorder(tree.left, k);
        if (left != null) return left;

        this.idx++;
        if (idx == k) return tree.val;

        return inorder(tree.right, k);
    }
}
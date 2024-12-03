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
    public boolean isSymmetric(TreeNode root) {
        return node(root.left, root.right);
    }

    public boolean node(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;

        if (leftNode == null || rightNode == null) return false;

        return leftNode.val == rightNode.val && node(leftNode.left, rightNode.right) && node(leftNode.right, rightNode.left);
    }
}
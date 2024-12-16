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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode tree) {
        if (tree == null) return 0;

        int left =  Math.max(maxGain(tree.left), 0);
        int right = Math.max(maxGain(tree.right), 0);

        int tmpSum = tree.val + left + right;

        maxSum = Math.max(maxSum, tmpSum);

        return tree.val + Math.max(left, right); 
    }
}
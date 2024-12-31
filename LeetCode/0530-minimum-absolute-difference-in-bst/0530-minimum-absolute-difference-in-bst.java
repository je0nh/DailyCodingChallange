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

    public int getMinimumDifference(TreeNode root) {
        this.inorder(root);

        int n = tmp.size();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i ++) {
            int abs = Math.abs(tmp.get(i) - tmp.get(i + 1));
            ans = ans > abs ? abs : ans;
        }
        return ans;
    }

    private void inorder(TreeNode tree) {
        if (tree == null) return;
        inorder(tree.left);
        tmp.add(tree.val);
        inorder(tree.right);
    }
}
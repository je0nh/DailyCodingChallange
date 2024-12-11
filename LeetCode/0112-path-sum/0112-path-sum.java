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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        Queue<Integer> val = new LinkedList<>();
        val.offer(root.val);
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode treeNode = q.poll();
                Integer nodeVal = val.poll();

                if (treeNode.left == null && treeNode.right == null) {
                    if (nodeVal == targetSum) {
                        return true;
                    }
                }

                if (treeNode.left != null) {
                    q.offer(treeNode.left);
                    val.offer(nodeVal + treeNode.left.val);
                }

                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                    val.offer(nodeVal + treeNode.right.val);
                }
            }
        }

        return false;
    }
}
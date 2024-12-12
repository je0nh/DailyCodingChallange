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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();
        q.offer(root);
        val.offer(root.val);

        int answer = 0;
        while (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            int v = val.poll();

            if (treeNode.left == null && treeNode.right == null) {
                answer += v;
            }

            if (treeNode.left != null) {
                q.offer(treeNode.left);
                val.offer(v * 10 + treeNode.left.val);
            }

            if (treeNode.right != null) {
                q.offer(treeNode.right);
                val.offer(v * 10 + treeNode.right.val);
            }
        }

        return answer;
    }
}
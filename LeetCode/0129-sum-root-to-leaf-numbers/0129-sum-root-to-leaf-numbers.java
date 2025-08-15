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
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        Pair<TreeNode, Integer> pair = new Pair<>(root, root.val);
        stack.add(pair);

        int ans = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> currNode = stack.pop();
            TreeNode node = currNode.getKey();
            int val = currNode.getValue();

            if (node.right == null && node.left == null) {
                ans += val;
            }

            if (node.left != null) {
                Pair<TreeNode, Integer> leftNode = new Pair<>(node.left, (val * 10) + node.left.val);
                stack.add(leftNode);
            }
            if (node.right != null) {
                Pair<TreeNode, Integer> rightNode = new Pair<>(node.right, (val * 10) + node.right.val);
                stack.add(rightNode);
            }
        }
        return ans;
    }
}
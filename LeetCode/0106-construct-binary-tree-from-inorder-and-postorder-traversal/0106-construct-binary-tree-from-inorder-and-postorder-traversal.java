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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        ArrayList<Integer> newIn = new ArrayList<>();
        ArrayList<Integer> newPost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newIn.add(inorder[i]);
            newPost.add(postorder[i]);
        }

        return build(newIn, newPost);
    }

    private TreeNode build(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (inorder.isEmpty() || postorder.isEmpty()) {
            return null;
        }

        int n = postorder.size();
        Integer root = postorder.get(n - 1);
        TreeNode tree = new TreeNode(root);

        int idx = inorder.indexOf(root);

        ArrayList<Integer> leftIn = new ArrayList<>(inorder.subList(0, idx));
        ArrayList<Integer> rightIn = new ArrayList<>(inorder.subList(idx + 1, inorder.size()));

        ArrayList<Integer> leftPost = new ArrayList<>(postorder.subList(0, leftIn.size()));
        ArrayList<Integer> rightPost = new ArrayList<>(postorder.subList(leftIn.size(), postorder.size() - 1));

        tree.left = build(leftIn, leftPost);
        tree.right = build(rightIn, rightPost);

        return tree;
    }
}
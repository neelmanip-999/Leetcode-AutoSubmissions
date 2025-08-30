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
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        List<Integer> vals = new ArrayList<>();
        for (TreeNode node : nodes) {
            vals.add(node.val);
        }
        Collections.sort(vals);
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).val = vals.get(i);
        }
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }
}

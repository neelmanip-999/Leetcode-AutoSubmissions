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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Preorder(root, ans);

        TreeNode curr = root;
        for (int i = 1; i < ans.size(); i++) {
            curr.left = null;
            curr.right = new TreeNode(ans.get(i));
            curr = curr.right;
        }
    }

    public void Preorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        Preorder(root.left, ans);
        Preorder(root.right, ans);
    }
}

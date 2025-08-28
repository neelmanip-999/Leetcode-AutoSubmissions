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
    public boolean checkTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        boolean left = checkTree(root.left);
        boolean right = checkTree(root.right);
        boolean check = false;
        // int i = root.left != null ? root.left.val:0;
        // int j = root.right != null ? root.right.val:0;
        if(root.val == root.left.val + root.right.val){
            check = true;
        }
        return left && right && check;
    }
}
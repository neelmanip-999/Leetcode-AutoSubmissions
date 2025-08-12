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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for(int num : to_delete){
            deleteSet.add(num);
        }
        List<TreeNode> forest = new ArrayList();
        root = helper(root, deleteSet, forest);
        if(root != null){
            forest.add(root);
        }
        return forest;
    }

    public TreeNode helper(TreeNode root, Set<Integer> deleteSet,List<TreeNode> forest ){
        if(root == null){
            return null;
        }
        root.left = helper(root.left, deleteSet, forest);
        root.right = helper(root.right, deleteSet, forest);
        if(deleteSet.contains(root.val)){
            if(root.left != null){
                forest.add(root.left);
            }
            if(root.right != null){
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }
}
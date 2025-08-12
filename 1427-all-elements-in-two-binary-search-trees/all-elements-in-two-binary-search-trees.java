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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Fill(root1, ans);
        Fill(root2, ans);
        Collections.sort(ans);
        return ans;
    }

    public static void Fill(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        Fill(root.left, ans);
        ans.add(root.val);
        Fill(root.right, ans);
    }
}
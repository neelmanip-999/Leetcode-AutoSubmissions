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
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        int c = minCamera(root);
        if(c == -1){
            camera++;
        }
        return camera;
    }

    public int minCamera(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if(left == -1 || right == -1){ // camera ki need hai
            camera++;
            return 1; // camera set up kara hai 
        }
        else if(left == 1 || right == 1){
            return 0; // not required
        }
        else{
            return -1;
        }
    }
}

// 0 --> already covered
// 1 --> have camera
// -1 --> need camera

// 0 --> agar dono child ke pass camera hai ya kisi ek ke pass camera hai.
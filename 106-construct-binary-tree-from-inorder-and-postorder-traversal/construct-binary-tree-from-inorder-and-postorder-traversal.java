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
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int plo, int phi, int[] inorder, int ilo, int ihi) {
        if (ilo > ihi || plo > phi) {
            return null;
        }
        TreeNode nn = new TreeNode();
        nn.val = postorder[phi];
        int idx = Search(inorder, ilo, ihi, postorder[phi]);
        int ne = idx - ilo;
        nn.left = build(postorder, plo, plo + ne - 1, inorder, ilo, ilo+ne);
        nn.right = build(postorder, plo + ne, phi - 1, inorder, ilo+ne+1, ihi);
        return nn;
    }

    public int Search(int[] arr, int si, int ei, int target) {
        for (int i = si; i <= ei; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return 0;
    }
}

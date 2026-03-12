class Solution {
    List<List<Integer>> ans;    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        Solve(root, targetSum, new ArrayList<>());
        return ans;
    }

    public void Solve(TreeNode root, int targetSum, List<Integer> ll){
        if (root == null) {
            return;
        }
        ll.add(root.val);        
        if (root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<>(ll));
        } else {
            Solve(root.left, targetSum - root.val, ll);
            Solve(root.right, targetSum - root.val, ll);
        }        
        ll.remove(ll.size() - 1);
    }
}
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        List<List<Integer>> result = new ArrayList<>();
        for (int q : queries) {
            int floor = getFloor(inorder, q);
            int ceil = getCeil(inorder, q);
            List<Integer> pair = new ArrayList<>();
            pair.add(floor);
            pair.add(ceil);
            result.add(pair);
        }
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public int getFloor(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) {
                ans = list.get(mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public int getCeil(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) {
                ans = list.get(mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
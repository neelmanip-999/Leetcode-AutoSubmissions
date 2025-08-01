class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates); 
        Combination(candidates, target, current, 0, ans);
        return ans;
    }

    private void Combination(int[] candidates, int target, List<Integer> current, int index, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current)); 
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue; 
            }
            if (candidates[i] > target) {
                break; 
            }

            current.add(candidates[i]); 
            Combination(candidates, target - candidates[i], current, i + 1, ans);
            current.remove(current.size() - 1); 
        }
    }
}

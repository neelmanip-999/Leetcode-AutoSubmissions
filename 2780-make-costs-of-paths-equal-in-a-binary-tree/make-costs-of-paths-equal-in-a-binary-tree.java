class Solution {
    int moves = 0;

    public int minIncrements(int n, int[] cost) {
        dfs(0, cost);
        return moves;
    }

    public int dfs(int i, int[] cost){
        if(i >= cost.length) return 0;
        int left = dfs(2*i+1, cost);
        int right = dfs(2*i+2, cost);
        moves += Math.abs(left-right);
        
        return cost[i] + Math.max(left, right);
    }
}
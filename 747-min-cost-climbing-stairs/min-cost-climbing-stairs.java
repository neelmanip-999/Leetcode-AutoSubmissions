class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int zero = Solve(cost, 0, dp);
        int one = Solve(cost, 1, dp);
        return Math.min(zero, one);
    }

    public int Solve(int[] arr, int idx, int[] dp){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int f = Solve(arr, idx+1, dp);
        int s = Solve(arr, idx+2, dp);
        return dp[idx] = Math.min(f, s) + arr[idx];
    }
}
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int a = Solve(nums, 0, nums.length-1, dp);
        Arrays.fill(dp, -1);
        int b = Solve(nums, 1, nums.length, dp);
        return Math.max(a, b);
    }
    public int Solve(int[] nums, int i, int j, int[] dp){
        if(i >= j) return 0;
        if(dp[i] != -1) return dp[i]; 
        int pick = nums[i] + Solve(nums, i+2, j, dp);
        int notPick = Solve(nums, i+1, j, dp);
        return dp[i] = Math.max(pick, notPick);
    }
}
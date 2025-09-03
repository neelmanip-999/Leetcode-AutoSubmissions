class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Solve(nums, 0, dp);
    }

    public int Solve(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int s = Solve(nums, i+1, dp);
        int f = Solve(nums, i+2, dp) + nums[i];
        return dp[i] = Math.max(s,f);
    }
}
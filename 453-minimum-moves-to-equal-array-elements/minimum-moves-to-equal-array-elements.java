class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int low = Integer.MAX_VALUE;
        int moves = 0;
        for(int i = 0; i<n; i++){
            low = Math.min(low, nums[i]);
        }
        for(int i = 0; i<n; i++){
            moves += nums[i] - low;
        }
        return moves;
    }
}
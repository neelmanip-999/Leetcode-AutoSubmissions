class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for(int i = 0; i<k; i++){
            kSum[i] = Long.MAX_VALUE/2;
        }
        kSum[k-1] = 0;
        for(int i = 0; i<n; i++){
            prefSum += nums[i];
            maxSum = Math.max(maxSum, prefSum - kSum[i%k]);
            kSum[i%k] = Math.min(kSum[i%k], prefSum);
        }
        return maxSum;
    }
}
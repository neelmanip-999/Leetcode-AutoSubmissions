class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total += x;

        if (k == n) return total;

        int window = 0, minSum;
        for (int i = 0; i < n - k; i++) window += nums[i];
        minSum = window;

        for (int i = n - k; i < n; i++) {
            window += nums[i] - nums[i - (n - k)];
            minSum = Math.min(minSum, window);
        }

        return total - minSum;
    }
}

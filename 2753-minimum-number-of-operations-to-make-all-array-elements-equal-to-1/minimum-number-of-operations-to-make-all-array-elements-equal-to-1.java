class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int v : nums) if (v == 1) ones++;
        if (ones > 0) return n - ones;
        int gAll = 0;
        for (int v : nums) gAll = gcd(gAll, v);
        if (gAll > 1) return -1;
        int minOps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                cur = gcd(cur, nums[j]);
                if (cur == 1) {
                    minOps = Math.min(minOps, j - i);
                    break;
                }
            }
        }
        return minOps == Integer.MAX_VALUE ? -1 : minOps + n - 1;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        int[][][] dp = new int[m][n][k];
        int firstRem = grid[0][0] % k;
        dp[0][0][firstRem] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int valRem = grid[i][j] % k;
                if (i == 0 && j == 0) continue;
                if (i > 0) {
                    for (int rem = 0; rem < k; rem++) {
                        int ways = dp[i - 1][j][rem];
                        if (ways == 0) continue;
                        int newRem = (rem + valRem) % k;
                        dp[i][j][newRem] = (int)((dp[i][j][newRem] + (long)ways) % MOD);
                    }
                }
                if (j > 0) {
                    for (int rem = 0; rem < k; rem++) {
                        int ways = dp[i][j - 1][rem];
                        if (ways == 0) continue;
                        int newRem = (rem + valRem) % k;
                        dp[i][j][newRem] = (int)((dp[i][j][newRem] + (long)ways) % MOD);
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}

class Solution {
    public int minCost(int[][] g) {
        int m = g.length, n = g[0].length;
        boolean[][] dp = new boolean[n][1024];
        dp[0][g[0][0]] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                boolean[] nxt = new boolean[1024];
                if (i > 0) {
                    for (int x = 0; x < 1024; x++) if (dp[j][x]) nxt[x] = true;
                }
                if (j > 0) {
                    for (int x = 0; x < 1024; x++) if (dp[j - 1][x]) nxt[x] = true;
                }
                boolean[] cur = new boolean[1024];
                for (int x = 0; x < 1024; x++) {
                    if (nxt[x]) cur[x ^ g[i][j]] = true;
                }
                dp[j] = cur;
            }
        }
        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) return x;
        }
        return 0;
    }
}
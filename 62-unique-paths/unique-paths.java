class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];  
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return Solve(0, 0, n-1, m-1, dp);
    }

    public int Solve(int cr, int cc, int er, int ec, int[][] dp) {
        if (cr == er && cc == ec) return 1;        
        if (cr > er || cc > ec) return 0;          
        if (dp[cr][cc] != -1) return dp[cr][cc];  

        int down = Solve(cr+1, cc, er, ec, dp);
        int right = Solve(cr, cc+1, er, ec, dp);

        return dp[cr][cc] = down + right;
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }   
        return Minimum_Path(grid, 0, 0, dp);
    }
    public static int Minimum_Path(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }
        int d = Minimum_Path(grid, cr + 1, cc, dp);
        int r = Minimum_Path(grid, cr, cc + 1, dp);
        return dp[cr][cc] = Math.min(d, r) + grid[cr][cc];
    }
}
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        
        int maxSide = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                
                if (i > maxSide && j > maxSide) {
                    int currentSum = dp[i][j] - dp[i - maxSide - 1][j] - dp[i][j - maxSide - 1] + dp[i - maxSide - 1][j - maxSide - 1];
                    if (currentSum <= threshold) {
                        maxSide++;
                    }
                }
            }
        }
        
        return maxSide;
    }
}
class Solution {
    int[][] moves = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {-1, 2}, {1, -2}, {-1, -2}
    };
    public double knightProbability(int n, int k, int row, int col) {
        double[][] dp = new double[n][n];
        dp[row][col] = 1.0;
        for(int step = 1; step<=k; step++){
            double[][] next = new double[n][n];
            for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    if(dp[r][c] > 0){
                        for(int[] move : moves){
                            int nr = r + move[0];
                            int nc = c + move[1];
                            if(nr >= 0 && nr<n && nc>=0 && nc<n){
                                next[nr][nc] += dp[r][c]/8.0;
                            }
                        }
                    }
                }
            }
            dp = next;
        }
        double ans = 0.0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<n; c++){
                ans += dp[r][c];
            }
        }
        return ans;
    }
}
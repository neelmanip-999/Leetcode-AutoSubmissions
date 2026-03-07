class Solution {

    int MOD = 1000000007;
    int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j],-1);

        return dfs(m,n,startRow,startColumn,maxMove);
    }

    int dfs(int m,int n,int r,int c,int moves){

        if(r<0 || r>=m || c<0 || c>=n) return 1;
        if(moves==0) return 0;

        if(dp[r][c][moves]!=-1) return dp[r][c][moves];

        long ans=0;

        ans+=dfs(m,n,r+1,c,moves-1);
        ans+=dfs(m,n,r-1,c,moves-1);
        ans+=dfs(m,n,r,c+1,moves-1);
        ans+=dfs(m,n,r,c-1,moves-1);

        return dp[r][c][moves]=(int)(ans%MOD);
    }
}
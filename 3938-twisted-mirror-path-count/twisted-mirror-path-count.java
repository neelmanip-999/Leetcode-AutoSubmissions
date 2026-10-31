class Solution {
    int m,n; int[][] g,mR,mD; static final int MOD=1000000007;
    public int uniquePaths(int[][] grid) {
        g=grid;m=g.length;n=g[0].length;
        mR=new int[m][n];mD=new int[m][n];
        for(int[] a:mR) Arrays.fill(a,-2);
        for(int[] a:mD) Arrays.fill(a,-2);
        long[][] dp = new long[m][n]; dp[0][0]=1;
        int i=0;
        while(i<m){
            int j = 0;
            while(j<n){
                if(g[i][j]==0&&dp[i][j]>0){
                    long w = dp[i][j];
                    if(j+1<n){
                        int d=go(i,j+1,0);
                        if(d!=-1){
                            int r=d/n,c=d%n;
                            dp[r][c]=(dp[r][c]+w)%MOD;
                        }
                    }
                    if(i+1<m){
                        int d=go(i+1,j,1);
                        if(d!=-1){
                            int r=d/n,c=d%n;
                            dp[r][c]=(dp[r][c]+w)%MOD;
                        }
                    }
                }
                j++;
            }
            i++;
        }
        return (int)(dp[m-1][n-1] % MOD);
    }
    public int go(int r, int c, int d){
        if(r<0||c<0||r>=m||c>=n) return -1;
        if(d==0&&mR[r][c]!=-2)return mR[r][c];
        if(d==1&&mD[r][c]!=-2)return mD[r][c];
        if(g[r][c]==0){
            int p=r*n+c;
            if(d==0)mR[r][c]=p;else mD[r][c]=p;
            return p;
        }
        int res=d==0?(r+1>=m?-1:go(r+1,c,1)):(c+1>=n?-1:go(r,c+1,0));
        if(d==0)mR[r][c]=res;else mD[r][c]=res;
        return res;
    }
}
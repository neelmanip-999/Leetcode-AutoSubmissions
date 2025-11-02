class Solution {
    int n, m;
    char[][] grid;
    boolean[][] vis;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    void dfs(int x, int y, int d) {
        while (x >= 0 && y >= 0 && x < n && y < m) {
            if (grid[x][y] == 'W' || grid[x][y] == 'G') return;
            vis[x][y] = true;
            x += dx[d];
            y += dy[d];
        }
    }

    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        this.n = n;
        this.m = m;
        grid = new char[n][m];
        vis = new boolean[n][m];
        for (int[] w : walls) grid[w[0]][w[1]] = 'W';
        for (int[] g : guards) grid[g[0]][g[1]] = 'G';
        for (int[] g : guards) {
            for (int d = 0; d < 4; d++) dfs(g[0] + dx[d], g[1] + dy[d], d);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] != 'W' && grid[i][j] != 'G' && !vis[i][j]) ans++;
        return ans;
    }
}

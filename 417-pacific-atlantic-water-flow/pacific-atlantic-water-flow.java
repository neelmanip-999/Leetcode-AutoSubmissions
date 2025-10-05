class Solution {
    int m, n;
    int[][] h;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        m = h.length;
        n = m == 0 ? 0 : h[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pac, Integer.MIN_VALUE);
            dfs(i, n - 1, atl, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pac, Integer.MIN_VALUE);
            dfs(m - 1, j, atl, Integer.MIN_VALUE);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    void dfs(int r, int c, boolean[][] vis, int prev) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (vis[r][c]) return;
        if (h[r][c] < prev) return;
        vis[r][c] = true;
        for (int[] d : dirs) {
            dfs(r + d[0], c + d[1], vis, h[r][c]);
        }
    }
}

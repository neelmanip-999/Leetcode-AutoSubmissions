class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();    
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = strs[i].charAt(j);
            }
        }
        int ans = 0;
        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                if (grid[row][col] < grid[row - 1][col]) {
                    ans++;
                    break;
                }
            }
        }   
        return ans;
    }
}

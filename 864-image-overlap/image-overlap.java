class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int dx = -n + 1; dx < n; dx++) {
            for (int dy = -n + 1; dy < n; dy++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, dx, dy));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int dx, int dy) {
        int n = img1.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x = i + dx;
            if (x < 0 || x >= n) continue;

            for (int j = 0; j < n; j++) {
                int y = j + dy;
                if (y < 0 || y >= n) continue;

                if (img1[i][j] == 1 && img2[x][y] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}

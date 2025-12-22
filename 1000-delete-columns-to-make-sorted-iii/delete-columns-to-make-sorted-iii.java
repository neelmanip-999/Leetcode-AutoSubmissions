class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        int maxKeep = 0;
        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                boolean canTake = true;
                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        canTake = false;
                        break;
                    }
                }
                if (canTake) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[i]);
        }
        return cols - maxKeep;
    }
}

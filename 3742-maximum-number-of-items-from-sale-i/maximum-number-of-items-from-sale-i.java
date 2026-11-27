class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        int min = Integer.MAX_VALUE;
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int cnt = 0;
            min = Math.min(min, price);
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    cnt++;
                }
            }
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + cnt);
            }
        }
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b] + (budget - b) / min);
        }
        return ans;
    }
}
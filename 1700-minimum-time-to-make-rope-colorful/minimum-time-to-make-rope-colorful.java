class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(prev)) {
                ans += Math.min(neededTime[i], neededTime[prev]);
                if (neededTime[i] > neededTime[prev]) prev = i;
            } else {
                prev = i;
            }
        }
        return ans;
    }
}

public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length, res = 0, sum = 0, l = 0;
        for (int r = 0; r < n; r++) {
            sum += fruits[r][1];
            while (l <= r && !canReach(fruits[l][0], fruits[r][0], startPos, k)) {
                sum -= fruits[l][1];
                l++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    private boolean canReach(int left, int right, int start, int k) {
        int option1 = Math.abs(start - left) + (right - left);
        int option2 = Math.abs(start - right) + (right - left);
        return Math.min(option1, option2) <= k;
    }
}

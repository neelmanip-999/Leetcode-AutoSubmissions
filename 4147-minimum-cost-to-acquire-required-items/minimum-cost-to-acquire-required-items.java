class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long n1 = need1;
        long n2 = need2;
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long cost0 = (n1 * c1) + (n2 * c2);
        long minK = Math.min(n1, n2);
        long costMin = (minK * cb) + ((n1 - minK) * c1) + ((n2 - minK) * c2);
        long maxK = Math.max(n1, n2);
        long costMax = maxK * cb;
        return Math.min(cost0, Math.min(costMin, costMax));
    }
}
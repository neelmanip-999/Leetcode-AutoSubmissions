class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long low = 0, high = (long)1e18;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];
        while (low < high) {
            long mid = (low + high + 1) >>> 1;
            if (can(stations, r, k, mid, prefix)) low = mid; else high = mid - 1;
        }
        return low;
    }

    boolean can(int[] stations, int r, long k, long target, long[] prefix) {
        int n = stations.length;
        long[] diff = new long[n + 1];
        long add = 0;
        for (int i = 0; i < n; i++) {
            add += diff[i];
            long total = range(prefix, i - r, i + r) + add;
            if (total < target) {
                long need = target - total;
                k -= need;
                if (k < 0) return false;
                add += need;
                int end = Math.min(n, i + 2 * r + 1);
                diff[end] -= need;
            }
        }
        return true;
    }

    long range(long[] p, int l, int r) {
        l = Math.max(0, l);
        r = Math.min(p.length - 2, r);
        return p[r + 1] - p[l];
    }
}
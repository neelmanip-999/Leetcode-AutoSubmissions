import java.util.*;

class Solution {
    public long sum(int n) {
        return (long) n * (n - 1) / 2;
    }

    public int countTrapezoids(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
        }
        long mod = 1_000_000_007;
        long count = 0;
        long sides = 0;
        for (Set<Integer> xSet : map.values()) {
            int sz = xSet.size();
            if (sz <= 1) continue;
            long ne = sum(sz);
            count = (count + sides * ne) % mod;
            sides = (sides + ne) % mod;
        }
        return (int) count;
    }
}

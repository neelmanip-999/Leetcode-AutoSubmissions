class Solution {
    public int lenLongestFibSubseq(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int x : a) s.add(x);
        int n = a.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = a[j], y = a[i] + a[j], len = 2;
                while (s.contains(y)) {
                    int z = y;
                    y += x;
                    x = z;
                    res = Math.max(res, ++len);
                }
            }
        }
        return res;
    }
}

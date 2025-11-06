class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n = c + 1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int[] e : connections) union(parent, rank, e[0], e[1]);
        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int r = find(parent, i);
            comp.computeIfAbsent(r, k -> new TreeSet<>()).add(i);
        }
        boolean[] online = new boolean[n];
        Arrays.fill(online, true);
        List<Integer> ansList = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            if (type == 1) {
                if (online[x]) ansList.add(x);
                else {
                    int r = find(parent, x);
                    TreeSet<Integer> ts = comp.get(r);
                    if (ts == null || ts.isEmpty()) ansList.add(-1);
                    else ansList.add(ts.first());
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                    int r = find(parent, x);
                    TreeSet<Integer> ts = comp.get(r);
                    if (ts != null) ts.remove(x);
                }
            }
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = ansList.get(i);
        return ans;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        int ra = find(parent, a), rb = find(parent, b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else {
            parent[rb] = ra;
            rank[ra]++;
        }
    }
}

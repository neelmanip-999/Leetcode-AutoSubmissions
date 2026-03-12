class Solution {
    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int low = 1, high = 200000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);
        int components = n;
        int upgrades = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < mid) return false;
                if (!dsu.union(e[0], e[1])) return false; 
                components--;
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= mid) {
                if (dsu.union(e[0], e[1])) {
                    components--;
                }
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < mid && e[2] * 2 >= mid) {
                if (dsu.union(e[0], e[1])) {
                    components--;
                    upgrades++;
                }
            }
        }

        return components == 1 && upgrades <= k;
    }
}
class Solution {
    double[] t, m;
    int[] c;

    public double separateSquares(int[][] sq) {
        int n = sq.length;
        double[] x = new double[2 * n];
        int k = 0;
        for (int[] s : sq) {
            x[k++] = s[0];
            x[k++] = s[0] + s[2];
        }
        Arrays.sort(x);
        m = new double[2 * n];
        int sz = 0;
        m[sz++] = x[0];
        for (int i = 1; i < 2 * n; i++) {
            if (x[i] != x[i - 1]) m[sz++] = x[i];
        }

        t = new double[8 * n];
        c = new int[8 * n];
        double[][] e = new double[2 * n][4];
        for (int i = 0; i < n; i++) {
            e[2 * i] = new double[]{sq[i][1], 1, sq[i][0], sq[i][0] + sq[i][2]};
            e[2 * i + 1] = new double[]{sq[i][1] + sq[i][2], -1, sq[i][0], sq[i][0] + sq[i][2]};
        }
        Arrays.sort(e, (a, b) -> Double.compare(a[0], b[0]));

        double tot = 0;
        double[] w = new double[2 * n];
        for (int i = 0; i < 2 * n - 1; i++) {
            u(1, 0, sz - 1, f(e[i][2], sz), f(e[i][3], sz), (int)e[i][1]);
            w[i] = t[1];
            tot += w[i] * (e[i + 1][0] - e[i][0]);
        }

        double h = tot / 2.0, cur = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            double dy = e[i + 1][0] - e[i][0];
            double area = w[i] * dy;
            if (cur + area >= h) {
                return e[i][0] + (h - cur) / w[i];
            }
            cur += area;
        }
        return e[2 * n - 1][0];
    }

    int f(double v, int sz) {
        int l = 0, r = sz - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (m[mid] == v) return mid;
            if (m[mid] < v) l = mid + 1;
            else r = mid - 1;
        }
        return 0;
    }

    void u(int o, int l, int r, int ql, int qr, int k) {
        if (ql >= r || qr <= l) return;
        if (ql <= l && r <= qr) c[o] += k;
        else {
            int mid = (l + r) / 2;
            u(2 * o, l, mid, ql, qr, k);
            u(2 * o + 1, mid, r, ql, qr, k);
        }
        if (c[o] > 0) t[o] = m[r] - m[l];
        else if (r - l == 1) t[o] = 0;
        else t[o] = t[2 * o] + t[2 * o + 1];
    }
}
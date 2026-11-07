class Solution {
    public int[] assignTasks(int[] s, int[] t) {
        int m = t.length;
        int[] res = new int[m];        
        PriorityQueue<int[]> f = new PriorityQueue<>((x, y) -> 
            x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]
        );
        PriorityQueue<long[]> b = new PriorityQueue<>((x, y) -> 
            Long.compare(x[0], y[0])
        );
        for (int i = 0; i < s.length; i++) {
            f.add(new int[]{s[i], i});
        }
        long time = 0;
        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);   
            if (f.isEmpty()) {
                time = b.peek()[0];
            }
            while (!b.isEmpty() && b.peek()[0] <= time) {
                long[] curr = b.poll();
                f.add(new int[]{(int) curr[1], (int) curr[2]});
            }
            int[] curr = f.poll();
            res[i] = curr[1];
            b.add(new long[]{time + t[i], curr[0], curr[1]});
        }
        return res;
    }
}
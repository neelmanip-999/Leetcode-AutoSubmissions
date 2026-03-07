class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        List<int[]>[] g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int[] e:edges){
            g[e[0]].add(new int[]{e[1],e[2]});
            g[e[1]].add(new int[]{e[0],e[2]});
        }
        
        int[] time=new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{passingFees[0],0,0});
        time[0]=0;
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0],u=cur[1],t=cur[2];
            
            if(u==n-1) return cost;
            
            for(int[] nei:g[u]){
                int v=nei[0],nt=t+nei[1];
                if(nt>maxTime) continue;
                if(nt<time[v]){
                    time[v]=nt;
                    pq.offer(new int[]{cost+passingFees[v],v,nt});
                }
            }
        }
        
        return -1;
    }
}
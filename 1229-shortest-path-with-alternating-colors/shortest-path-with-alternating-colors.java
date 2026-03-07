class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] r = new ArrayList[n];
        List<Integer>[] b = new ArrayList[n];
        for(int i=0;i<n;i++){r[i]=new ArrayList<>();b[i]=new ArrayList<>();}
        for(int[] e:redEdges) r[e[0]].add(e[1]);
        for(int[] e:blueEdges) b[e[0]].add(e[1]);
        
        int[][] d=new int[n][2];
        for(int[] x:d) Arrays.fill(x,Integer.MAX_VALUE);
        
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        q.offer(new int[]{0,1});
        d[0][0]=0;  // red
        d[0][1]=0;  //blue
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int u=cur[0],c=cur[1]; // u->node , c->color(0->red, 1->blue) ;
            if(c==0){ // red then explore blue
                for(int v:b[u]){
                    if(d[v][1]>d[u][0]+1){
                        d[v][1]=d[u][0]+1;
                        q.offer(new int[]{v,1});
                    }
                }
            }else{ // blue then explore red
                for(int v:r[u]){
                    if(d[v][0]>d[u][1]+1){
                        d[v][0]=d[u][1]+1;
                        q.offer(new int[]{v,0});
                    }
                }
            }
        }
        
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int x=Math.min(d[i][0],d[i][1]);
            ans[i]=x==Integer.MAX_VALUE?-1:x;
        }
        return ans;
    }
}
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        int turn = 0;
        for(int i = n-1; i>=0; i--){
            int val = happiness[i]-turn;
            if(val>=0 && k>0){
                ans+=val;
                turn++;
                k--;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}
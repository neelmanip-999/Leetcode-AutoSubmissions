class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int x:nums){
            int s=0, c=0;
            for(int i=1; i*i<=x; i++){
                if(x%i==0){
                    c++;
                    s+=i;
                    if(i*i != x){
                        c++;
                        s+=x/i;
                    }
                }
            }
            if(c==4) ans += s;
        }
        return ans;
    }
}
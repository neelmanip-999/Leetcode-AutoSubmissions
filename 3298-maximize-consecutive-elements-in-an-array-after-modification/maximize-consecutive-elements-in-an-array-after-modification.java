class Solution {
    int n;
    int[][]dp;
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        dp=new int[n+1][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int max=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,Math.max(helper(i,0,nums),helper(i,1,nums)));
        }
        return max;
    }
    public int helper(int i,int inc,int[] arr){
        if(dp[i][inc]!=-1)return dp[i][inc];
        int curVal=arr[i]+inc;
        int len=1;

        int j=findMethod(arr,i+1,curVal+1);
        if(j!=-1){
            len=Math.max(len,1+helper(j,0,arr));
        }

        j=findMethod(arr,i+1,curVal);
        if(j!=-1){
            len=Math.max(len,1+helper(j,1,arr));
        }
        return dp[i][inc]=len;
    }
    public int findMethod(int[]arr,int index,int val){
        int start=index,end=n-1,mid=0,ans=-1;
        while(start<=end){
            mid=start+(end-start)/2;
            if(arr[mid]>=val){
                if(arr[mid]==val)ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
}
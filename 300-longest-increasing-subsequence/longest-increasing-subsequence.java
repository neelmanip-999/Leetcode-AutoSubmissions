class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }

    public int LIS(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 0; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[i] > arr[j]){
                    int l = lis[j];
                    lis[i] = Math.max(lis[i], l+1);
                }
            }
        }
        int max = lis[0];
        for(int i = 1; i<n; i++){
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
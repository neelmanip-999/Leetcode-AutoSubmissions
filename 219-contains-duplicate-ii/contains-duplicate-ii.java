class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for(int i = 0; i<n-1; i++){
            if(arr[i][0] == arr[i+1][0] && Math.abs(arr[i][1]-arr[i+1][1]) <= k){
                return true;
            }
        }
        return false;
    }
}
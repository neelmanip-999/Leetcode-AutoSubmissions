class Solution {
    public long perfectPairs(int[] nums) {
       int n = nums.length;
        long count = 0;
        long[] absArr = new long[n];
        for(int i = 0; i < n; i++){
            absArr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(absArr);
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < n && absArr[j] <= 2L * absArr[i]){
                j++;
            }
            count += (j - i - 1);
        }
        return count;
    }
}

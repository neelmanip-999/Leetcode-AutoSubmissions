class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for(int i = n-1; i>=2; i--){
            int lo = 0;
            int hi = i-1;
            while(lo <= hi){
                if(nums[lo] + nums[hi] > nums[i]){
                    count += (hi-lo);
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        return count;
        
    }
}
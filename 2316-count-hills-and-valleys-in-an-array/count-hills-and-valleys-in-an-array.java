class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int last = nums[0];
        for(int i = 1; i<n-1; i++){
            if(nums[i] != nums[i+1]){
                if((nums[i] > last && nums[i] > nums[i+1]) || (nums[i] < last && nums[i] < nums[i+1])){
                    ans++;
                }
                last = nums[i];
            }
        }
        return ans;
    }
}
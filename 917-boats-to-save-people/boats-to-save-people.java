class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int ans = 0;
        int st = 0;
        int ei = nums.length-1;
        Arrays.sort(nums);
        while(st<=ei){
            if(nums[st] + nums[ei] <= limit){
                ans++;
                st++;
                ei--;
            }
            else{
                ei--;
                ans++;
            }
        }
        return ans;
    }
}
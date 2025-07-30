class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == max){
                cnt++;
                ans = Math.max(cnt, ans);
            }
            else{
                cnt = 0;
                ans = Math.max(cnt, ans);
            }
        }
        return ans;
    }
}
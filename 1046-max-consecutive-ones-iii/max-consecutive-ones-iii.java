class Solution {
    public int longestOnes(int[] nums, int k) {
        int st = 0, ei = 0;
        int ans = Integer.MIN_VALUE;
        int flip = 0;
        while(ei < nums.length){
            if(nums[ei] == 0){
                flip++;
            }
            while(flip > k && st <= ei){
                if(nums[st] == 0){
                    flip--;
                }
                st++;
            }
            ei++;
            ans = Math.max(ans, ei-st);
        }
        return ans;
    }
}
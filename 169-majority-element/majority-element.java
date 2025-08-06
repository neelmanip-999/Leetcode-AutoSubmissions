class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0];
        int cnt = 1;
        int ans = 0;
        for(int i = 1; i<n; i++){
            if(nums[i] == ele){
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else{
                cnt--;
                if(cnt == 0){
                    cnt = 1;
                    ele = nums[i];
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ele;
    }
}
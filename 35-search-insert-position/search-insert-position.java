class Solution {
    public int searchInsert(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                si = mid+1;
            }
            else{
                ei = mid-1;
            }
        }
        return si;
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max1 = nums[n-1];
        int max2 = Integer.MIN_VALUE;
        int index2 = -1;
        int max3 = Integer.MIN_VALUE;
        for(int i = n-2; i>=0; i--){
            if(nums[i] != max1){
                max2 = nums[i];
                index2 = i;
                break;
            }
        }
        for(int i = index2; i>=0; i--){
            if(nums[i] != max2){
                return nums[i];
            }
        }
        return nums[n-1];
    }
}
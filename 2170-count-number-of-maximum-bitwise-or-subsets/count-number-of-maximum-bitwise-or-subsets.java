class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;
        for(int num : nums){
            maxOrValue |= num;
        }
        return countSubsets(nums, 0, 0, maxOrValue);
    }
    public  int countSubsets(int[] nums, int idx, int currOr, int targetOr){
        if(idx == nums.length){
            return (currOr == targetOr) ? 1 : 0;
        }
        int skip = countSubsets(nums, idx+1, currOr, targetOr);
        int take = countSubsets(nums, idx+1, currOr | nums[idx], targetOr);
        return skip + take;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 || nums == null){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<nums.length-2; i++){
            int st = i+1;
            int end = nums.length-1;
            while(st < end){
                if(nums[i] + nums[st] + nums[end] == 0){
                    ans.add(Arrays.asList(nums[i], nums[st], nums[end]));
                    st++;
                    end--;
                }
                else if(nums[i] + nums[st] + nums[end] < 0){
                    st++;
                }
                else{
                    end--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, 1);
        for(int i = 0; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[j] < nums[i]){
                    int x = temp[j];
                    temp[i] = Math.max(temp[i], temp[j]+1);
                }
            }
        }
        Arrays.sort(temp);
        return temp[temp.length-1];
    }
}



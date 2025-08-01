class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int st = i + 1, end = nums.length - 1;
            while (st < end) {
                int sum = nums[i] + nums[st] + nums[end];            
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum < target) {
                    st++;
                } else if (sum > target) {
                    end--;
                } else {
                    return sum; 
                }
            }
        }
        return closest;
    }
}

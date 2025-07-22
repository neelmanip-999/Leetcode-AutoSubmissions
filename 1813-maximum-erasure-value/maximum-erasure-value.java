class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        int st = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;
        while(end < n){
            while(seen.contains(nums[end])){
                seen.remove(nums[st]);
                sum -= nums[st];
                st++;
            }
            seen.add(nums[end]);
            sum += nums[end];
            ans = Math.max(ans, sum);
            end++;
        }
        return ans;
    }
}













// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         int st = 0;
//         int end = 0;
//         int ans = 0;
//         int sum = 0;
//         while(end < n){
//             hm.put(nums[end], hm.getOrDefault(nums[end], 0)+1);
//             while(hm.get(nums[end]) > 1 && end >= st){
//                 hm.put(nums[st], hm.get(nums[st])-1);
//                 sum -= nums[st];
//                 st++;
//             }
//             sum += nums[end];
//             ans = Math.max(ans, sum);
//             end++;           
//         }
//         return ans;
//     }
// }
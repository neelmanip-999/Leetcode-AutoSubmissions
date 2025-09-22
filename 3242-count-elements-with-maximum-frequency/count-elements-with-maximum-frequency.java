class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> ll = new ArrayList<>();
        for(Integer val : hm.keySet()){
            ll.add(hm.get(val));
        }
        Collections.sort(ll);
        int sum = 0;
        sum += ll.get(ll.size()-1);
        for(int i = ll.size()-2; i>=0; i--){
            if(ll.get(i) == ll.get(i+1)){
                sum += ll.get(i);
            }
            else{
                break;
            }
        }
        return sum;
    }
}
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> ll = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                ll.add(i);
            }
        }
        return Check(ll, k);
    }
    public boolean Check(List<Integer> ll, int k){
        int n=ll.size();
        for(int i=0;i<n-1;i++){
            if(ll.get(i+1)-ll.get(i)-1 < k) return false;
        }
        return true;
    }
}
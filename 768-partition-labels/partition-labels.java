class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for(int i = 0; i<s.length(); i++){
            arr[s.charAt(i)-'a'] = i;
        }
        int end = 0;
        int str = 0;
        for(int i = 0; i<s.length(); i++){
            end = Math.max(end, arr[s.charAt(i)-'a']);
            if(i == end){
                res.add(end - str + 1);
                str = i + 1;
            }
        }
        return res;
    }
}
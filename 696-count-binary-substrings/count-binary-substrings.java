class Solution {
    public int countBinarySubstrings(String s) {
        int[] arr = new int[s.length()];
        int cnt = 1;
        arr[0] = 1;
        int k = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){
                arr[++k] = 1;
            }
            else{
                arr[k]++;
            }
        }
        int ans = 0;
        for(int i = 1; i<=k; i++){
            ans += Math.min(arr[i-1], arr[i]);
        }
        return ans;
    }
}
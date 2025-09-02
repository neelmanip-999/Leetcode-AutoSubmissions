class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int si = 0, ei = 0, maxFreq = 0, ans = 0;
        int[] freq = new int[26];
        while(ei < n){
            freq[s.charAt(ei)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(ei)-'A']);
            while((ei-si+1) - maxFreq > k){
                freq[s.charAt(si)-'A']--;
                si++;
            }
            ans = Math.max(ans, ei-si+1);
            ei++;
        }
        return ans;
    }
}
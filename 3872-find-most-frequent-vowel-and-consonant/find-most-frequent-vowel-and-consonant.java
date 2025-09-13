class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxvowel = 0;
        int maxconso = 0;
        for(int i = 0; i<26; i++){
            char ch = (char)(i+'a');
            if(isVowel(ch)){
                maxvowel = Math.max(maxvowel, freq[i]);
            }
            else{
                maxconso = Math.max(maxconso, freq[i]);
            }
        }
        return maxvowel+maxconso;
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
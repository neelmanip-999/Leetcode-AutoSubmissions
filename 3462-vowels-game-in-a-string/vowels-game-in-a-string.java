class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)) count++;
        }
        if(count == 0) return false;
        return true;
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
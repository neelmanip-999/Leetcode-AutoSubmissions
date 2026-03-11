class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\s+");
        String ans = "";
        for(int i = str.length-1; i>=0; i--){
            ans += str[i];
            ans += " ";
        }
        return ans.trim();
    }
}
class Solution {
    public int minOperations(String s) {
        int ans1 = 0;
        int ans2 = 0;
        char[] ch1 = s.toCharArray();
        char[] ch2 = s.toCharArray();
        ch1[0] = '0';
        ch2[0] = '1';
        for(int i = 1; i<ch1.length; i++){
            if(ch1[i-1] == ch1[i] && ch1[i] == '0'){
                ch1[i] = '1';
                ans1++;
            } 
            else if(ch1[i-1] == ch1[i] && ch1[i] == '1'){
                ch1[i] = '0';
                ans1++;
            }
            else continue; 
        }
        for(int i = 1; i<ch2.length; i++){
            if(ch2[i-1] == ch2[i] && ch2[i] == '0'){
                ch2[i] = '1';
                ans2++;
            } 
            else if(ch2[i-1] == ch2[i] && ch2[i] == '1'){
                ch2[i] = '0';
                ans2++;
            } 
            else continue; 
        }
        if(s.charAt(0) == '0') ans2++;
        else ans1++; 
        return Math.min(ans1, ans2);
    }
}
class Solution {
    public boolean checkString(String s) {
        int lastA = -1;
        int firstB = -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'b'){
                firstB = i;
                break;
            }
        }
        for(int i = s.length()-1; i>= 0; i--){
            if(s.charAt(i) == 'a'){
                lastA = i;
                break;
            }
        }
        if(firstB == -1) return true;
        if(lastA > firstB) return false;
        return true;
    }
}
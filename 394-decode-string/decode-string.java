class Solution {
    public String decodeString(String s) {
        Stack<Integer> cntSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10 + (ch-'0');
            }
            else if(ch == '['){
                cntSt.push(k);
                strSt.push(curr);
                curr = new StringBuilder();
                k = 0;
            }
            else if(ch == ']'){
                int repeat = cntSt.pop();
                StringBuilder prev = strSt.pop();
                for(int i = 0; i<repeat; i++){
                    prev.append(curr);
                }
                curr = prev;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
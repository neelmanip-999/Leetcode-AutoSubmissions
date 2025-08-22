class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<op.length; i++){
            if(op[i].equals("C")){
                st.pop();
            }
            else if(op[i].equals("D")){
                st.push(2*st.peek());
            }
            else if(op[i].equals("+")){
                int a = st.pop();
                int b = st.pop();
                int s = a+b;
                st.push(b);
                st.push(a);
                st.push(s);
            }
            else{
                st.push(Integer.parseInt(op[i]));
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
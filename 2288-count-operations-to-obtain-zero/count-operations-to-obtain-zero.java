class Solution {
    public int cnt=0;
    public int countOperations(int num1, int num2) {
        if(num1<=0 || num2<=0){
            return cnt;
        }
        if(num1>num2){
            cnt++;
            return countOperations(num1-num2,num2);
        }
        else{
            cnt++;
            return countOperations(num1,num2-num1);
        }
    }
}
class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        int a = 0;
        int b = 1;
        for(int i = 0; i<=n-2; i++){
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
}
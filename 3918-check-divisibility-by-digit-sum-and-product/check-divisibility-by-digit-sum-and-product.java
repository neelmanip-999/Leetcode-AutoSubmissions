class Solution {
    public boolean checkDivisibility(int n) {
        long product = 1;
        int sum = 0;
        int copy = n;
        while(n > 0){
            int temp = n%10;
            product *= temp;
            sum += temp;
            n /= 10;
        }
        int div = (int)(product) + sum;
        return copy%div == 0;
    }
}
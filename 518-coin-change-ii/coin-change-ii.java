class Solution {
    public int change(int amount, int[] coin) {
        int[][] dp = new int[coin.length][amount+1];

        // Base case: one way to make amount = 0 (take nothing)
        for(int i = 0; i < coin.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < coin.length; i++) {
            for(int am = 1; am <= amount; am++) {
                int inc = 0, exc = 0;

                if(am >= coin[i]) {
                    inc = dp[i][am - coin[i]]; // include coin[i]
                }
                if(i > 0) {
                    exc = dp[i-1][am]; // exclude coin[i]
                }

                dp[i][am] = inc + exc;
            }
        }
        return dp[coin.length-1][amount];
    }
}

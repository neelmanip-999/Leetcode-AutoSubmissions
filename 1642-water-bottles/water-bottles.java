class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            int newB = empty/numExchange;
            ans += newB;
            empty = newB + (empty%numExchange);
        }
        return ans;
    }
}
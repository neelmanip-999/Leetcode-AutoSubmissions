class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int i = 0;
        int mx = n>0?nums[0]:0;
        do{
            mx = nums[i]>mx?nums[i]:mx;
            i++;
        } while(i<n);
        i = 0;
        int moves = 0;
        do{
            moves += mx-nums[i];
            i++;
        }while(i<n);
        return moves;
    }
}
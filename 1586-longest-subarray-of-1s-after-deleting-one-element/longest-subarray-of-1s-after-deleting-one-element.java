class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int p = 0, c = 0, r = 0;
        boolean z = false;
        for (int v : nums) {
            if (v == 1) c++;
            else {
                z = true;
                r = Math.max(r, p + c);
                p = c;
                c = 0;
            }
        }
        r = Math.max(r, p + c);
        return z ? r : n - 1;
    }
}
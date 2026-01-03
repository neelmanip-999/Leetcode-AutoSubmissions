class Solution {
    public int numOfWays(int n) {
        long mod = (long) 1e9 + 7;
        long aba = 6;
        long abc = 6;
        for (int i = 2; i <= n; i++) {
            long nextAba = (3 * aba + 2 * abc) % mod;
            long nextAbc = (2 * aba + 2 * abc) % mod;
            aba = nextAba;
            abc = nextAbc;
        }
        return (int) ((aba + abc) % mod);
    }
}
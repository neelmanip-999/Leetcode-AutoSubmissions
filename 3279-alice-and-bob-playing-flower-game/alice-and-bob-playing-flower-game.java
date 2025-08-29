class Solution {
    public long flowerGame(int n, int m) {
        long ceilN = (n + 1L) / 2;
        long floorN = n / 2L;
        long ceilM = (m + 1L) / 2;
        long floorM = m / 2L;
        return ceilN * floorM + floorN * ceilM;
    }
}

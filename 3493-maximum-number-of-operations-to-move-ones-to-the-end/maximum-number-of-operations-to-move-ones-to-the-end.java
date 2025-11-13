class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] prefOnes = new int[n];
        prefOnes[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefOnes[i] = prefOnes[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        boolean sorted = true;
        boolean seenOne = false;
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1') seenOne = true;
            if (seenOne && s.charAt(k) == '0') { sorted = false; break; }
        }
        if (sorted) return 0;

        int ops = 0;
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) == '0') {
                i--;
                while (i >= 0 && s.charAt(i) == '0') i--;
                int endIndex = i;
                int onesBefore = endIndex >= 0 ? prefOnes[endIndex] : 0;
                ops += onesBefore;
            } else {
                i--;
            }
        }

        return ops;
    }
}

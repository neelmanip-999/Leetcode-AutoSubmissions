class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        boolean[] fixed = new boolean[rows - 1];
        int ans = 0;
        for (int c = 0; c < cols; c++) {
            boolean delete = false;
            for (int r = 0; r < rows - 1; r++) {
                if (!fixed[r] && strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    delete = true;
                    break;
                }
            }
            if (delete) {
                ans++;
            } else {
                for (int r = 0; r < rows - 1; r++) {
                    if (!fixed[r] && strs[r].charAt(c) < strs[r + 1].charAt(c)) {
                        fixed[r] = true;
                    }
                }
            }
        }
        return ans;
    }
}

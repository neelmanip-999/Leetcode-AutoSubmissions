class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, maxLen = 0;

        //odd
        for (int axis = 0; axis < n; axis++) {
            for (int orbit = 0; axis - orbit >= 0 && axis + orbit < n; orbit++) {
                if (s.charAt(axis - orbit) != s.charAt(axis + orbit)) break;
                int len = 2 * orbit + 1;
                if (len > maxLen) {
                    maxLen = len;
                    start = axis - orbit;
                }
            }
            
            // even
            for (int orbit = 0; axis - orbit >= 0 && axis + orbit + 1 < n; orbit++) {
                if (s.charAt(axis - orbit) != s.charAt(axis + orbit + 1)) break;
                int len = 2 * orbit + 2;
                if (len > maxLen) {
                    maxLen = len;
                    start = axis - orbit;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

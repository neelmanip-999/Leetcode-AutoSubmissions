class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128]; 
        int i = 0, maxLength = 0;
        for (int j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            freq[currentChar]++;
            while (freq[currentChar] > 1) {
                freq[s.charAt(i)]--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}

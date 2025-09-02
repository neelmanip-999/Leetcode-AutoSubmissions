class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), si = 0, ans = 0;
        int[] freq = new int[3];

        for (int ei = 0; ei < n; ei++) {
            freq[s.charAt(ei) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += n - ei;
                freq[s.charAt(si) - 'a']--;
                si++;
            }
        }
        return ans;
    }
}

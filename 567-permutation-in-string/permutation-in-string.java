// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) return false;

//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];

//         for (int i = 0; i < s1.length(); i++) {
//             freq1[s1.charAt(i) - 'a']++;
//             freq2[s2.charAt(i) - 'a']++;
//         }

//         if (Arrays.equals(freq1, freq2)) return true;

//         for (int i = s1.length(); i < s2.length(); i++) {
//             freq2[s2.charAt(i) - 'a']++;
//             freq2[s2.charAt(i - s1.length()) - 'a']--;
//             if (Arrays.equals(freq1, freq2)) return true;
//         }

//         return false;
//     }
// }

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            window[c - 'a']++;
            right++;

            while (right - left == s1.length()) {
                if (Arrays.equals(need, window)) return true;

                char d = s2.charAt(left);
                window[d - 'a']--;
                left++;
            }
        }

        return false;
    }
}

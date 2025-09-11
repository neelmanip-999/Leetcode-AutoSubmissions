class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int idx = 0; 
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}

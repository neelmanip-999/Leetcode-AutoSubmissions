class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            brokenSet.add(ch);
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean canType = true;
            for (char ch : word.toCharArray()) {
                if (brokenSet.contains(ch)) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }

        return count;
    }
}

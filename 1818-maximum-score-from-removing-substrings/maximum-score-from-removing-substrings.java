class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeSubstrings(s, x, "ab", y, "ba");
        } else {
            return removeSubstrings(s, y, "ba", x, "ab");
        }
    }

    public int removeSubstrings(String s, int firstVal, String firstSub, int secondVal, String secondSub) {
        int score = 0;
        Deque<Character> stack1 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peekLast() == firstSub.charAt(0) && c == firstSub.charAt(1)) {
                stack1.removeLast();
                score += firstVal;
            } else {
                stack1.addLast(c);
            }
        }

        Deque<Character> stack2 = new ArrayDeque<>();
        while (!stack1.isEmpty()) {
            char c = stack1.removeFirst();
            if (!stack2.isEmpty() && stack2.peekLast() == secondSub.charAt(0) && c == secondSub.charAt(1)) {
                stack2.removeLast();
                score += secondVal;
            } else {
                stack2.addLast(c);
            }
        }

        return score;
    }
}

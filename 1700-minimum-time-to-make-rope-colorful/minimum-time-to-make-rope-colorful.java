class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < colors.length(); i++) {
            while (!st.isEmpty() && colors.charAt(st.peek()) == colors.charAt(i)) {
                if (neededTime[st.peek()] < neededTime[i]) {
                    ans += neededTime[st.pop()];
                } else {
                    ans += neededTime[i];
                    i++;
                    if (i == colors.length()) return ans;
                }
            }
            st.push(i);
        }
        return ans;
    }
}
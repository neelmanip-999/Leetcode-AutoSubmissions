class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int y : curr) {
                next.add(x | y);
            }
            res.addAll(next);
            curr = next;
        }
        return res.size();
    }
}
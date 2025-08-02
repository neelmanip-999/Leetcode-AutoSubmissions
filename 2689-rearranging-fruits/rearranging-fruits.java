public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : basket1)
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);

        for (int x : basket2)
            countMap.put(x, countMap.getOrDefault(x, 0) - 1);

        List<Integer> extra = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int fruit = entry.getKey();
            int freq = entry.getValue();
            minValue = Math.min(minValue, fruit);

            if (freq % 2 != 0)
                return -1;

            for (int i = 0; i < Math.abs(freq) / 2; i++) {
                extra.add(fruit);
            }
        }

        Collections.sort(extra);

        long cost = 0;
        int half = extra.size() / 2;

        for (int i = 0; i < half; i++) {
            cost += Math.min(extra.get(i), 2 * minValue);
        }

        return cost;
    }
}

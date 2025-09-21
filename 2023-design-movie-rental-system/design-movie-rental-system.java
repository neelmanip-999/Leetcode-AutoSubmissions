import java.util.*;

class MovieRentingSystem {
    static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) { shop = s; movie = m; price = p; }
    }

    private final Map<String, Integer> priceMap = new HashMap<>();
    private final Map<Integer, TreeSet<int[]>> available = new HashMap<>();
    private final TreeSet<int[]> rented = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        if (a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);

            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            })).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        TreeSet<int[]> set = available.get(movie);
        int count = 0;
        for (int[] e : set) {
            if (count == 5) break;
            result.add(e[1]);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] e : rented) {
            if (count == 5) break;
            result.add(Arrays.asList(e[1], e[2]));
            count++;
        }
        return result;
    }
}

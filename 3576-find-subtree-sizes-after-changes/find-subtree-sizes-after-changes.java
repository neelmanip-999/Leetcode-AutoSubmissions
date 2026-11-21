class Solution {

    private void updateParents(
        int node,
        List<List<Integer>> children,
        String s,
        int[] parent,
        int[] lastOccurrence,
        int[] updatedParent
    ) {
        int character = s.charAt(node) - 'a';
        int previousOccurrence = lastOccurrence[character];

        updatedParent[node] = previousOccurrence == -1
            ? parent[node]
            : previousOccurrence;

        lastOccurrence[character] = node;

        for (int child : children.get(node)) {
            updateParents(child, children, s, parent,
                lastOccurrence, updatedParent);
        }

        lastOccurrence[character] = previousOccurrence;
    }

    private void calculateSubtreeSizes(
        int node,
        List<List<Integer>> children,
        int[] subtreeSize
    ) {
        subtreeSize[node] = 1;

        for (int child : children.get(node)) {
            calculateSubtreeSizes(child, children, subtreeSize);
            subtreeSize[node] += subtreeSize[child];
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> children = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        for (int node = 1; node < n; node++) {
            children.get(parent[node]).add(node);
        }

        int[] lastOccurrence = new int[26];
        Arrays.fill(lastOccurrence, -1);

        int[] updatedParent = new int[n];

        updateParents(0, children, s, parent,
            lastOccurrence, updatedParent);

        for (int node = 0; node < n; node++) {
            children.get(node).clear();
        }

        for (int node = 1; node < n; node++) {
            children.get(updatedParent[node]).add(node);
        }

        int[] subtreeSize = new int[n];

        calculateSubtreeSizes(0, children, subtreeSize);

        return subtreeSize;
    }
}
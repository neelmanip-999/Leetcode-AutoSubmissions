class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> spiralList = new ArrayList<>();
        int minr = 0;
        int maxr = arr.length - 1;
        int minc = 0;
        int maxc = arr[0].length - 1;
        int totalElements = arr.length * arr[0].length;
        int count = 0;

        while (count < totalElements) {
            // Traverse from left to right
            for (int i = minc; i <= maxc && count < totalElements; i++) {
                spiralList.add(arr[minr][i]);
                count++;
            }
            minr++;

            // Traverse from top to bottom
            for (int i = minr; i <= maxr && count < totalElements; i++) {
                spiralList.add(arr[i][maxc]);
                count++;
            }
            maxc--;

            // Traverse from right to left
            for (int i = maxc; i >= minc && count < totalElements; i--) {
                spiralList.add(arr[maxr][i]);
                count++;
            }
            maxr--;

            // Traverse from bottom to top
            for (int i = maxr; i >= minr && count < totalElements; i--) {
                spiralList.add(arr[i][minc]);
                count++;
            }
            minc++;
        }

        return spiralList;
    }
}

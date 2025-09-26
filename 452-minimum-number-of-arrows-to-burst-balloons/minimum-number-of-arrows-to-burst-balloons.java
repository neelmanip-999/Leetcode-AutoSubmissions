class Solution {
    public int findMinArrowShots(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int end = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] > end){
                arrows++;
                end = intervals[i][1];
            }
        }
        return arrows;
    }
}
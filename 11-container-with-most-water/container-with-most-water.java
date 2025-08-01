class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(st < end){
            int area = Math.min(height[st], height[end])*(end-st);
            maxArea = Math.max(area, maxArea);
            if(height[st] < height[end]){
                st++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
}
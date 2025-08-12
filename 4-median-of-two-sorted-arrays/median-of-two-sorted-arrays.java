class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int arr[] = new int[l1+l2];
        for (int i=0;i<l1;i++){
            arr[i]=nums1[i];
        }
        for (int i = 0;i<l2;i++){
            arr[i+l1]=nums2[i];
        }
        Arrays.sort(arr);
        int l = l1+l2;
        double median =0;
        if (l%2==0){  // for even
            median = (double)((arr[(l/2)-1]+arr[l/2]))/2;
        }
        else {  // for odd
            median = arr[(l-1)/2];
        }
        return median;
    }
}
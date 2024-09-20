package com.soulmeadows;

public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;

        int l = 0;
        int r = m;
        while(true){
            int i = (l + r) / 2; // A
            int j = half  - i - 2; // B

            int aleft = (i >= 0) ? nums1[i]: Integer.MIN_VALUE;
            int aright = (i + 1 < m) ? nums1[i + 1]: Integer.MAX_VALUE;
            int bleft = (j >= 0) ?  nums2[j] : Integer.MIN_VALUE;
            int bright = (j +1 < n) ? nums2[j + 1]: Integer.MAX_VALUE;

            if(aleft <= bright && bleft <= aright){
                if (total % 2 == 1){
                    return Math.max(aleft, bleft);
                }else{
                    return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
                }
            }else if(aleft > bright){
                r = i - 1;
            }else {
                l = i + 1;
            }
        }
        //return 0.0;

    }

    public static void main(String[] args){
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        new MedianSortedArrays().findMedianSortedArrays(nums1, nums2);
    }
}

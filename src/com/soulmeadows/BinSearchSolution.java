package com.soulmeadows;

public class BinSearchSolution {

    public int binarySearch(int[] nums, int value) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == value) {
                return mid;
            }
            if(nums[mid] < value){
                start = mid + 1;
            } else {

                end = mid - 1;
            }
        }
        return -1;
    }
}

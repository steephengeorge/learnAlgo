package com.soulmeadows;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int largestSum = Integer.MIN_VALUE;
        for(int num: nums) {
            currentSum += num;
            if(largestSum < currentSum) {
                largestSum = currentSum;
            }

            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return largestSum;
    }
}

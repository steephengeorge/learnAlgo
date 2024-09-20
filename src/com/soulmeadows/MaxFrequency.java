package com.soulmeadows;

import java.util.Arrays;

public class MaxFrequency {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int total = 0;
        int res = 0;

        while(right < nums.length){
            total += nums[right];

            while((nums[right] * (right - left + 1)) > (total + k)){
                total -= nums[left];
                ++left;
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {10,9,9,9,9, 9,9,9,9,9};
        int k = 10;
        System.out.println(nums.length);
        System.out.println(maxFrequency(nums, k));
        int a = 100000 * 30000;
        if(  a > 130000 ){
            System.out.println("helo");
        }else {
            System.out.println(100000 * 30000);
        }

    }
}

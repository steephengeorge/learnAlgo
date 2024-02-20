package com.soulmeadows;

import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            var remainder = target - nums[i];
            if(map.containsKey(remainder)){
                return new int[] {map.get(remainder), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        var result = twoSum(nums, 6);
        for( int i = 0 ; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
}



package com.soulmeadows;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
public class MinOperations {
    public int minOperations(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(var num: nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        int res = 0;
        for(var num: map.values()){
            if(num == 1){
                return -1;
            }
            res += Math.ceil(num / 3.0);
        }
        return res;
    }

    public static void main(String[] args){
       // int[] nums= {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        int[] nums= {2,3,3,2,2,4,2,3,4};
        System.out.println(new MinOperations().minOperations(nums));
    }
}

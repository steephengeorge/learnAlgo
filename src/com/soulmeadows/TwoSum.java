package com.soulmeadows;

import java.util.*;

class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i])){
                var value = map.get(nums[i]);
                value.add(i);
                map.put(nums[i], value);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(nums[i], list);
        }

        for(int i = 0; i < nums.length; ++i) {
            Integer another = target - nums[i];
            if(nums[i] == another) {
                var result = map.get(another);
                if(result.size() >= 2) {
                    return new int[]{result.get(0), result.get(1)};
                }
                continue;
            }
            if(map.containsKey(another)){
                List<Integer> result = map.get(another);
                return new int[] { i, result.get(0)};
            }

        }

        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        twoSum(nums, 6);
    }
}



package com.soulmeadows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        var result = new ArrayList<List<Integer>>();
        if(start == nums.length){
            return result;
        }
        int avg = target / k;
        if(avg > nums[nums.length - 1] || nums[start] > avg){
            return result;
        }
        if(k == 2){
            return twoSum(nums, start, target);
        }
        for(int i = start; i < nums.length; ++i){
            if(i == start || nums[i -1] != nums[i]){
                for(var subList: kSum(nums, target - nums[i], i + 1, k - 1)){
                    result.add(subList);
                    result.get(result.size() - 1).add(nums[i]);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target){
        var result = new ArrayList<List<Integer>>();
        var set = new HashSet<Integer>();
        for(int i = start; i < nums.length; ++i){
            int remain = target - nums[i];
            if(result.isEmpty() || result.get(result.size() - 1).get(1) != nums[i]){
                if(set.contains(remain)){
                    var currentList = new ArrayList<Integer>();
                    currentList.add(nums[i]);
                    currentList.add(remain);
                    result.add(currentList);
                    return result;
                }
            }
            set.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        var result = new FourSum().fourSum(nums, 0);
    }
}

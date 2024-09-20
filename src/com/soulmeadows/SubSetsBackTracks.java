package com.soulmeadows;

import java.util.List;
import java.util.ArrayList;

public class SubSetsBackTracks {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<Integer> (), nums, 0);
        return list;
    }

    public static void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        if(start >= nums.length) return ;
        else {
            list.add(temp);
            for(int i = start; i < nums.length; ++i){
                temp.add(nums[i]);
                backTrack(list, new ArrayList<Integer>(), nums, i);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
       subsets(nums);
    }
}

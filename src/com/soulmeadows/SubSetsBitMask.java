package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;

public class SubSetsBitMask {
    public static List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        int n = nums.length;
        for(int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i){
            String bitmask = Integer.toBinaryString(i).substring(1);

            var curr = new ArrayList<Integer>();
            for(int k = 0; k < n; ++k){
                if(bitmask.charAt(k) == '1'){
                    curr.add(nums[k]);
                }
            }
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(subsets(nums));
    }
}

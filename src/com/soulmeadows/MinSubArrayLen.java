package com.soulmeadows;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        var list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        Integer sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += list.get(i);
            if(sum >= target){
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;
        System.out.println(minSubArrayLen(target, nums));
    }
}

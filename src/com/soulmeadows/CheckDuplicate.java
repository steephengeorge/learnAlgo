package com.soulmeadows;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        var test = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if(test.size() == nums.length) {
            return false;
        }
        return true;
    }
}

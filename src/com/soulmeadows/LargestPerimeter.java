package com.soulmeadows;

import java.util.Arrays;

// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
public class LargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long max = -1l;
        for(var num: nums){

            if(otherSum > num && nums.length >= 3){
                max = Math.max(sum, max);
            }else{
                sum -= nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987};
        System.out.println(new LargestPerimeter().largestPerimeter(nums));
    }
}

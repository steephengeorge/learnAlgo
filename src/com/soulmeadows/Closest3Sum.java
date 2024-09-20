package com.soulmeadows;

import java.util.Arrays;

public class Closest3Sum {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; ++i){
            int left = 0;
            int right = nums.length - 1;
            while(left < right){
                if(left == i || right == i){
                    break;
                }
                int sum = nums[left] + nums[i] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target- best)){
                    best = sum;
                }
                if(sum == target){
                    return target;
                }else if(sum > target){
                    --right;
                    while(right >= 0 && nums[right] == nums[right + 1]){
                        --right;
                    }
                }else if (sum < target){
                    ++left;
                    while(left < nums.length && nums[left] == nums[left - 1]){
                        ++left;
                    }
                }
            }
        }
        return best;
    }

    public static void main(String[] args){
        int[] nums = {0,1,2};
        threeSumClosest(nums, 0);
    }

}

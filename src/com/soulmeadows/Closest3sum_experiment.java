package com.soulmeadows;

import java.util.Arrays;
public class Closest3sum_experiment {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        for(int i = 0; i < nums.length; ++i){
            if(i == 0 || nums[i] != nums[i-1]){
                if(result[1] == target){
                    break;
                }
                helper(nums, i, target, result);
            }
        }
        return result[0];
    }
    private void helper(int[] nums, int start, int target, int[] result){
        int left = start + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[start] + nums[right];
            if(Math.abs(sum - target) == 0){
                result[0] = sum;
                result[1] = 0;
                break;
            }else if (sum < target){
                if(result[1] >  target - sum){
                    result[1] = target - sum;
                    result[0] = sum;
                }
                ++left;
            }else {
                if(result[1] > sum - target){
                    result[1] = sum - target;
                    result[0] = sum;
                }
                --right;
            }
        }
    }
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        new Closest3sum_experiment().threeSumClosest(nums, 1);
    }
}

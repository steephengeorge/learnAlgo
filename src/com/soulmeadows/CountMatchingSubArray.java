package com.soulmeadows;
//https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/

public class CountMatchingSubArray {
    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;
        for(int i = 0; i < n - m ; ++i){
            boolean status = true;
            for(int j = i, k = 0; j < n - 1 && k < m ; ++j, ++k){
                if(pattern[k] == 1 && nums[j+1] <= nums[j]){
                    status = false;
                    break;
                }else if( pattern[k] == -1 && nums[j+1] >= nums[j]){
                    status = false;
                    break;
                }else if(pattern[k] == 0 && nums[j+1] != nums[j]){
                    status = false;
                    break;
                }
            }
            if(status) ++count;
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {846123688,626200286,846123688};
        int[] pattern = {1};
        System.out.println(countMatchingSubarrays(nums, pattern));
    }
}

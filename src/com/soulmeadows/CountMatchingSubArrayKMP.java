package com.soulmeadows;
//https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-ii/description/
public class CountMatchingSubArrayKMP {
    private static int[] longestPrefixSuffix(int[] pattern){
        int[] lps = new int[pattern.length];
        int prevLps = 0;
        int i = 1;
        while(i < pattern.length){
            if(pattern[i] == pattern[prevLps]){
                lps[i] = prevLps + 1;
                ++i;
                ++prevLps;
            }else if(prevLps == 0){
                ++i;
            }else {
                prevLps = lps[prevLps -1];
            }
        }
        return lps;
    }

    private static int[] patternizeNums(int[] nums){
        int[] nums2 = new int[nums.length - 1];
        for(int i =0; i < nums.length - 1; ++i){
            if(nums[i] < nums[i + 1]){
                nums2[i] = 1;
            }else if(nums[i] > nums[i + 1]){
                nums2[i] = -1;
            }else {
                nums2[i] = 0;
            }
        }
        return nums2;
    }
    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int [] lps = longestPrefixSuffix(pattern);
        int [] nums2 = patternizeNums(nums);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < nums2.length){
            if(nums2[i] == pattern[j]){
                ++i;
                ++j;
            }else if(j == 0){
                ++i;
            }else {
                j = lps[j - 1];
            }
            if(j == pattern.length){
                ++count;
                j = lps[j - 1];
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {846123688,626200286,846123688};
        int[] pattern = {1};
        System.out.println(countMatchingSubarrays(nums, pattern));

        int[] nums1 = new int[]{481251768, 481251768, 481251768, 463564806};
        int[] pattern1 = new int[]{0};
        System.out.println(countMatchingSubarrays(nums1, pattern1));

        int[] nums2 = new int[]{81322310,152123803,483414167,483414167,483414167,483414167,483414167,483414167,483414167,483414167};
        int[] pattern2 = new int[]{0,0,0};
        System.out.println(countMatchingSubarrays(nums2, pattern2));

        int[] nums3 = new int[]{705835710,560798845,705835710,560798845,560798845,329926763};
        int[] pattern3 = new int[]{-1,1,-1,0,-1};
        System.out.println(countMatchingSubarrays(nums3, pattern3));

    }
}

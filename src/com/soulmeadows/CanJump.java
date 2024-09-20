package com.soulmeadows;

public class CanJump {
    public static boolean canJump(int[] nums) {
        boolean[] status = new boolean[nums.length];
        for(int i = 0; i < nums.length; ++i){
            int j = 0;
            while(j < nums[i] && i + j + 1 < nums.length){
                status[i+j + 1] = true;
                ++j;
            }
            if(status[nums.length - 1]){
                return true;
            }
        }
        return status[nums.length -1];
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        //System.out.println(canJump(nums));
        int[] nums1 = {0};
        System.out.println(canJump(nums1));
    }
}

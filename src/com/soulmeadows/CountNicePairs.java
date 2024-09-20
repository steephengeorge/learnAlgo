package com.soulmeadows;

import java.util.HashMap;

public class CountNicePairs {
    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for(var num: nums){
            int val = createReverse(num);
            arr[i++] = num - val;
        }
        int ans = 0;
        var map = new HashMap<Integer, Integer>();
        for(var num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(var count: map.values()){
            if(count > 2){
                ans += count;
            }else if(count > 1){
                ans += 1;
            }
        }
        return ans;
    }
    private int createReverse(int num){
        int res = 0;
        int remainder = 0;
        while(num > 0){
            remainder = num % 10;
            num = num / 10;
            res = res * 10 + remainder;
        }
        return res;
    }

    public static void main(String[] args){
        var counter =new CountNicePairs();

        int[] nums = {42,11,1,97};
        System.out.println(counter.countNicePairs(nums));

        int[] nums1 = {13,10,35,24,76};
        System.out.println(counter.countNicePairs(nums1));
    }
}

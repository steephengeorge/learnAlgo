package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/find-k-closest-elements/description/
public class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid]  > x - arr[mid + k] ){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        var result = new ArrayList<Integer>();
        for(int i = left; i < left + k; ++i){
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        new KClosest().findClosestElements(nums, 3, 4);
    }
}

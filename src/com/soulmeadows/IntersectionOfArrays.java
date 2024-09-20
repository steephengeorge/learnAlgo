package com.soulmeadows;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for(var num: nums1){
            set.add(num);
        }
        var result = new ArrayList<Integer>();
        for(var num: nums2){
            if(set.contains(num)){
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        while(i < result.size()){
            ans[i] = result.get(i++);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {1,2,2,3};
        int[] b = {2,2};
        int[] result = new IntersectionOfArrays().intersection(a, b);
        for(var el: result){
            System.out.println(el);
        }
    }
}

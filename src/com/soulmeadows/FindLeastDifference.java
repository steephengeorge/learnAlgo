package com.soulmeadows;

import java.util.Arrays;

public class FindLeastDifference {

    public static void main(String[] args){
        int[] a= {1,29,7, 6, 9,8, 14};
        int[] b = {12, 23, 256, 356, 23, 7, 19};
        System.out.println("Result: " + findLeastDifference(a, b));
        System.out.println("Result: " + findLeastDifference(b, a));
        System.out.println("Result: " + findLeastDifference(a, a));
        System.out.println("Result: " + findLeastDifference(b, b));
    }

    private static int findLeastDifference(int[] first, int[] second){
        Arrays.sort(first);
        Arrays.sort(second);
        int n = first.length;
        int m = second.length;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < n && j < m){
            int currentDifference = Math.abs(first[i] - second[j]);
            if(currentDifference < min){
                min = currentDifference;
                ++j;
                continue;
            }
            ++i;
            j = 0;
        }
        return min;
    }
}

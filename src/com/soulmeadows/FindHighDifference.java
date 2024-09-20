package com.soulmeadows;

import java.util.Arrays;
import java.util.Comparator;

public class FindHighDifference {
    public static void main(String[] args){
        Integer[] a= {1,29,7, 6, 9,8, 14};
        Integer[] b = {12, 23, 256, 356, 23, 7, 19};
        System.out.println("Result: " + findHighDifference(a, b));
        System.out.println("Result: " + findHighDifference(b, a));
        System.out.println("Result: " + findHighDifference(a, a));
        System.out.println("Result: " + findHighDifference(b, b));
    }

    private static int findHighDifference(Integer[] first, Integer[] second){
        Arrays.sort(first, Comparator.reverseOrder());
        Arrays.sort(second, Comparator.reverseOrder());
        int n = first.length;
        int m = second.length;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        while(i < n &&  j < m){
            int currentDifference = Math.abs(first[i] - second[j]);
            if(currentDifference > max){
                max = currentDifference;
                ++j;
                continue;
            }
            ++i;
            j = 0;
        }
        return max;
    }

}

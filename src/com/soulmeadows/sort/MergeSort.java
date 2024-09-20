package com.soulmeadows.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class
MergeSort {

    public void mergeSort(int[] a){
        if(a.length < 2){
            return;
        }
        int mid = a.length / 2;
        int[] l = new int[mid];
        int[] r = new int[a.length - mid];
        for(int i = 0; i < mid; ++i){
            l[i] = a[i];
        }
        for(int i = mid; i < a.length; ++i){
            r[i - mid] = a[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(a, l, r);
    }
    public void merge(int[] result, int[]a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < a.length && j < b.length ){
            if(a[i] <= b[j]){
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while(i < a.length ){
            result[k++] = a[i++];
        }
        while(j < b.length ) {
            result[k++] = b[j++];
        }
    }

    @Test
    public void testMergeSort(){
        int[] a = {12, 5, 6, 7, 2, 4, 23};
        int[] expected = {2, 4, 5, 6, 7, 12, 23};
        mergeSort(a);
        assertArrayEquals(a, expected);
    }
}

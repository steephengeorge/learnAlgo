package com.soulmeadows;

public class QuickSort {

    public static int partition(int[] nums, int begin, int end) {
        int pivot = nums[end];
        int i = begin - 1;
        for(int j = begin; j < end; ++j) {
            if(pivot >= nums[j]) {
                ++i;

                int tmp = nums[j];
                nums[j] = nums[i];
                nums[j] = tmp;
            }
        }
        int tmp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = tmp;
        return ++i;
    }
    public static void quickSort(int[] nums, int begin, int end){
        if(begin < end) {
            int partitionIndex = partition(nums, begin, end);
            quickSort(nums, begin, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, end);
        }
    }

    public static void main(String [] args) {
        int[] first = {3, 8, 6, 7, 5, 9, 10} ;
       // int[] second = Arrays.stream(first).sorted().toArray();
        quickSort(first, 0, first.length -1);
        for(int x: first){
            System.out.println(x);
        }
    }

}

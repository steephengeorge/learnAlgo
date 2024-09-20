package com.soulmeadows;

import java.util.Collections;
import java.util.PriorityQueue;
//Code Signal problem
public class MedianFinder_2 {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder_2() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void add(int value) {
        // write your code here
        maxHeap.add(value);
        minHeap.add(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public boolean delete(int value) {
        //write your code here
        if(maxHeap.contains(value)){
            var status = maxHeap.remove(value);

            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            return status;
        }
        if(minHeap.contains(value)){
            var status = minHeap.remove(value);
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
            return status;
        }
        return false;
    }

    /*
    GET_MEDIAN should return the median integer - the integer value in the middle of the sequence
     after all integer value stored in the container are sorted from smallest to largest.
     If the length of the sorted sequence is even, the leftmost integer from the two middle integers
     should be returned. If the container is empty, this method should raise a runtime exception.
    */
    public int getMedian() {
        // write your code here
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        if(maxHeap.size() > 0){
            return maxHeap.peek();
        }else {
            throw new RuntimeException();
        }
    }


    public  static  void main(String[] args){
        var container = new MedianFinder_2();
        container.add(5);
        container.add(3);
        container.add(5);
        container.add(7);
        container.add(8);
        container.add(9);
        System.out.println(container.getMedian());
//        Assertions.assertTrue(container.delete(5));
//        Assertions.assertTrue(container.delete(8));
//        System.out.println(container.getMedian());
//        Assertions.assertTrue(container.delete(5));
//        Assertions.assertFalse(container.delete(5));
//        System.out.println(container.getMedian());
//        container.add(5);
//        System.out.println(container.getMedian());
//        Assertions.assertTrue(container.delete(5));
//        Assertions.assertFalse(container.delete(5));
//        Assertions.assertTrue(container.delete(7));
//        Assertions.assertTrue(container.delete(3));
//        System.out.println(container.getMedian());
//        Assertions.assertTrue(container.delete(9));
//        Assertions.assertThrows(
//                RuntimeException.class,
//                () -> container.getMedian()
//        );
//        Assertions.assertFalse(container.delete(9));
//        Assertions.assertThrows(
//                RuntimeException.class,
//                () -> container.getMedian()
//        );
//        container.add(3);
//        container.add(30);
//        container.add(30);
//        container.add(15);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(30));
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(30));
//        System.out.println(container.getMedian());
//        container.add(30);
//        container.add(30);
//        container.add(30);
//        System.out.println(container.getMedian());
//        container.add(15);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(20));
//        System.out.println(container.delete(3));
//        System.out.println(container.getMedian());
//        //System.out.println(container.getMedian());
//        System.out.println(container.delete(5));
//       // System.out.println(container.getMedian());
//        System.out.println(container.delete(5));
//        container.add(5);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(5));
        //System.out.println(container.getMedian());
//
//        System.out.println(container.delete(5));
//        container.add(5);
//        container.add(4);
//        container.add(3);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(5));
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(5));
//        System.out.println(container.delete(3));
//        System.out.println(container.getMedian());
//        container.add(10);
//        container.add(20);
//        container.add(30);
//        System.out.println(container.delete(20));
//        System.out.println(container.getMedian());
//        container.add(5);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(30));
//        System.out.println(container.getMedian());
//        for (int i = 0; i < 20; ++i) {
//            container.add(42);
//        }
//        System.out.println(container.getMedian());
//        for (int i = 0; i < 30; ++i) {
//            container.add(i);
//        }
//        System.out.println(container.getMedian());
//        for (int i = 0; i < 50; ++i) {
//            container.add(130);
//        }
//        System.out.println(container.getMedian());
//        for (int i = 0; i < 50; ++i) {
//            container.add(170);
//        }
//        System.out.println(container.getMedian());
//        container.add(1);
//        container.add(2);
//        container.add(3);
//        container.add(4);
//        container.add(5);
//        container.add(5);
//        container.add(5);
//        System.out.println(container.getMedian());
//        container.add(2);
//        System.out.println(container.getMedian());
//        container.add(3);
//        System.out.println(container.getMedian());
//        container.add(5);
//        container.add(5);
//        System.out.println(container.getMedian());
////        container.add(1);
//        System.out.println(container.getMedian());
//        container.add(3);
//        container.add(4);
//        container.add(2);
//        container.add(10);
//        container.add(30);
//        System.out.println(container.getMedian());
//        container.add(52);
//        container.add(53);
//        container.add(54);
//        container.add(55);
//        System.out.println(container.getMedian());
//        container.add(6);
//        container.add(7);
//        container.add(8);
//        container.add(9);
//        System.out.println(container.getMedian());
//        container.add(11);
//        System.out.println(container.getMedian());
//        container.add(1);
//        container.add(2);
//        container.add(5);
//        container.add(7);
//        container.add(9);
//        System.out.println(container.getMedian());
//        container.add(3);
//        container.add(4);
//        System.out.println(container.getMedian());

//        container.add(30);
//        container.add(10);
//        System.out.println(container.getMedian());
//        container.add(12);
//        container.add(35);
//        System.out.println(container.getMedian());
//        System.out.println(container.getMedian());
//        container.add(11);
//        container.add(40);
//        container.add(100);
//        container.add(90);
//        System.out.println(container.getMedian());
//        container.delete(4);
//        //System.out.println(container.getMedian());
//        for (int i = 10; i >= 1; --i) {
//            container.add(i);
//        }
//        System.out.println(container.getMedian());
//        for (int i = 4; i <= 6; ++i) {
//            container.delete(i);
//        }
//        System.out.println(container.getMedian());

//        container.add(1);
//        container.add(1);
//        container.add(2);
//        container.add(2);
//        container.add(2);
//        System.out.println(container.getMedian());
//        container.delete(2);
//        System.out.println(container.getMedian());
//        container.delete(1);
//        System.out.println(container.getMedian());
//        container.add(5);
//        container.add(3);
//        container.add(5);
//        System.out.println(container.getMedian());
//        container.delete(5);
//        container.delete(5);
//        container.delete(5);
//        System.out.println(container.getMedian());
//        container.delete(3);
//        System.out.println(container.getMedian());
//        container.add(1);
//        container.add(2);
//        System.out.println(container.getMedian());
//        container.add(3);
//        System.out.println(container.getMedian());

//        container.add(1);
//        container.add(2);
//        container.add(5);
//        container.add(4);
//        System.out.println(container.getMedian());
//        System.out.println(container.delete(1));
//        System.out.println(container.getMedian());
    }
}

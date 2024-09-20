package com.soulmeadows;
// https://leetcode.com/problems/maximum-performance-of-a-team/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPerformance {
    record Pair<Integer>(Integer key, Integer value){}
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        var candidates = new ArrayList<Pair>();
        for(int i = 0; i < n; ++i){
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        Collections.sort(candidates, Comparator.comparing(obj -> -(int)obj.key()));
        var minHeap = new PriorityQueue<Integer>();
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for(var candidate: candidates){
            if(minHeap.size() > k - 1){
                currSum -= minHeap.poll();
            }
            minHeap.add((int)candidate.value());
            currSum += (int) candidate.value();
            max = Math.max(max, currSum * (int)candidate.key());
        }
        return max;
    }

    public static void main(String[] args){
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};

        System.out.println(new MaxPerformance().maxPerformance(6, speed, efficiency, 2));
    }
}

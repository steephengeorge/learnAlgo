package com.soulmeadows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// https://leetcode.com/problems/maximum-number-of-intersections-on-the-chart/description/

public class MaxIntersectionCount {
    public int maxIntersectionCount(int[] y) {
        //Sweep Line
        var map = new HashMap<Integer, Integer>();

        for(int i = 1; i < y.length; ++i){
            int min = Math.min(y[i], y[i -1]);
            int max = Math.max(y[i], y[i -1]);
            map.put(min, map.getOrDefault(min, 0) + 1);
            map.put(max, map.getOrDefault(max, 0) - 1);
        }
        var events = new ArrayList<int[]>();
        for(var entry: map.entrySet()){
            events.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int curr = 0;
        int max = 0;
        for(var event: events){
            curr += event[1];
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {2,3,4,3,4,1,4,1,2,3,4,2,1,2,1,3,2};
        System.out.println(new MaxIntersectionCount().maxIntersectionCount(nums));
    }
}

package com.soulmeadows;

import java.util.ArrayDeque;

public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        var stack = new ArrayDeque<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }

        while(stack.peek() != -1){
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}

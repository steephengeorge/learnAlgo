package com.soulmeadows;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
class RottingOranges {
    record Pair<Integer>(Integer key, Integer value){}
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer>> queue = new ArrayDeque();

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        for(int r = 0; r < rows; ++r){
            for(int c = 0; c < cols; ++c){
                if(grid[r][c] == 2){
                    queue.offer(new Pair(r, c));
                } else if(grid[r][c] == 1){
                    ++freshOranges;
                }
            }
        }
        queue.offer(new Pair(-1, -1));
        int minutesElapsed = -1;
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){

            Pair<Integer> p = queue.poll();
            int r = p.key();
            int c = p.value();
            if(r == -1) {
                ++minutesElapsed;
                if(!queue.isEmpty()) {
                    queue.offer(new Pair(-1, -1));
                }
            }
            for(int[] d: directions) {
                int neighborRow = r + d[0];
                int neighborCol = c + d[1];
                if(neighborRow >= 0 && neighborRow < rows &&
                        neighborCol >= 0 && neighborCol < cols
                ){
                    if(grid[neighborRow][neighborCol] == 1){
                        grid[neighborRow][neighborCol] = 2;
                        --freshOranges;
                        queue.offer(new Pair(neighborRow, neighborCol));
                    }

                }

            }

        }
        return freshOranges == 0 ? minutesElapsed: -1;
    }
}
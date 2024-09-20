package com.soulmeadows;

import java.util.*;

public class CountIslands {

    private Deque<int[]> queue = new ArrayDeque<>();
    private Set<List<Integer>> visited = new HashSet<>();

    public  int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;


        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == '1' && !visited.contains(List.of(i,j))){
                    ++islands;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid, int i, int j){
        int[][] moves = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        queue.add(new int[] {i, j});
        visited.add(List.of(i, j));
        while(!queue.isEmpty()){
            int[] current = queue.pollFirst();
            for(var move: moves){
                int r = current[0] + move[0];
                int c = current[1] + move[1];
                int[] next = new int[]{r, c};
                if( r >= m || r >= n || r < 0 || c < 0){
                    continue;
                }
                if(!visited.contains(List.of(r,c)) && grid[r][c] == '1' ){
                    queue.add(next);
                    visited.add(List.of(r,c));
                }
            }
        }
    }

    public static void main(String[] args){
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        CountIslands countIslands = new CountIslands();
        System.out.println(countIslands.numIslands(grid));
    }

}

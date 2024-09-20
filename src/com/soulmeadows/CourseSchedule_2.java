package com.soulmeadows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CourseSchedule_2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        var map = new HashMap<Integer, Integer>();
        for(var pre: prerequisites){
            count[pre[1]]++;
            map.put(pre[0], pre[1]);
        }
        var res = new ArrayList<Integer>();
        boolean[] visited = new boolean[numCourses];
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < numCourses; ++i){
                if(!visited[prerequisites[i][0]]){
                    if(count[prerequisites[i][0]] == 0){
                        visited[prerequisites[i][0]] = true;
                        res.add(prerequisites[i][0]);
                        flag = true;
                        count[prerequisites[i][1]]--;
                    }
                }
            }
        }
        if(res.size() == numCourses){
            int[] result = new int[numCourses];
            int i = 0;
            for(var val: res){
                result[i++] = val;
            }
            return result;
        }
        return new int[numCourses];
    }


    public static void main(String[] args){
//          int[][]  prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//          int numCourses = 4;
        int[][] prerequisites = {{1,0}};
        int numCourses = 2;
//        int[][] prerequisites = {{0,1}};
//        int numCourses = 2;
        var result = findOrder(numCourses, prerequisites);
        for(var course: result){
            System.out.print(course + ",");
        }
    }
}

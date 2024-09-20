package com.soulmeadows;
//https://leetcode.com/problems/min-cost-climbing-stairs/description/

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; ++i){
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    public static void main(String[] args){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        new MinCostClimbingStairs().minCostClimbingStairs(cost);
    }
}

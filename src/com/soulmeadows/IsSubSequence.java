package com.soulmeadows;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0){
            return true;
        }
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int i = 1; i <= sLen; ++i){
            for(int j = 1; j <= tLen; ++j){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }
        if(dp[sLen][tLen] == sLen){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new IsSubSequence().isSubsequence("abc", "ahbgdc"));
    }
}

package com.soulmeadows;

import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (var word : wordDict) {
                if(dp[i] == true){
                    if (i + word.length() <= s.length()) {

                        var partial = s.substring(i, i + word.length());
                        if (partial.equals(word)) {
                            dp[i + word.length()] = dp[i];
                        }

                    }
                }
            }
        }
        return dp[s.length()];

    }
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet","code")));
        System.out.println(wordBreak("aaaaaaa", List.of("aaaa","aaa")));
    }
}

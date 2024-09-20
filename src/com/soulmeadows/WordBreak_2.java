package com.soulmeadows;

import java.util.HashSet;
import java.util.List;

public class WordBreak_2 {
    // There are flows in this approach

    public boolean wordBreak(String s, List<String> wordDict) {
        var set = new HashSet<String>(wordDict);
        int left = 0;
        for(int right = 0; right < s.length(); ++right){
            String word = s.substring(left, right + 1);
            if(set.contains(word)){
                left = right + 1;
            }
        }
        return left >= s.length();
    }

    public static void main(String[] args){
        var wordDict = List.of("aaaa","aaa");
        new WordBreak_2().wordBreak("aaaaaaa", wordDict);
    }
}

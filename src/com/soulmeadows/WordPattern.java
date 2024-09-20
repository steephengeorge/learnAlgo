package com.soulmeadows;

import java.util.HashMap;

// https://leetcode.com/problems/word-pattern/
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        var mapPS = new HashMap<Character, String>();
        var  mapSP = new HashMap<String, Character>();
        for(int i = 0; i < pattern.length(); ++i){
            String word = words[i];
            Character c = s.charAt(i);

            if(!mapPS.containsKey(c)){
                mapPS.put(c, word);
            }
            if(!mapSP.containsKey(word)){
                mapSP.put(word, c);
            }
            if(!mapPS.get(c).equals(word)){
                return false;
            }
            if(mapSP.get(word) != c){
                return false;
            }
        }
        return true;
    }

    public static void  main(String[] args){
        new WordPattern().wordPattern("abba", "dog cat cat dog");
    }
}

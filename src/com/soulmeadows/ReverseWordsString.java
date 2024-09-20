package com.soulmeadows;
// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsString {
    public String reverseWords(String s) {
        s.trim();
        var parts = s.split(" ");
        var sb = new StringBuilder(parts[parts.length - 1]);
        for(int i = parts.length - 2; i >= 0; --i){
            if(!parts[i].equals("")){
                sb.append(" ");
                sb.append(parts[i]);
            }
        }
        return sb.toString();
    }
}

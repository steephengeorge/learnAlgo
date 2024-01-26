package com.soulmeadows;
//https://leetcode.com/problems/minimum-window-substring/description/

class MinWindowSubString {
    public String minWindow(String s, String t) {
        int[] lookUp = new int[256];
        for(char c: t.toCharArray()){
            lookUp[c]++;
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int counter = t.length();
        while(end < s.length()) {
            char sChar = s.charAt(end);
            ++end;
            if(lookUp[sChar] > 0){
                --counter;
            }
            --lookUp[sChar];

            while(counter == 0){
                if(minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                sChar = s.charAt(start);
                ++lookUp[sChar];
                if(lookUp[sChar] > 0) {
                    ++counter;
                }
                ++start;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
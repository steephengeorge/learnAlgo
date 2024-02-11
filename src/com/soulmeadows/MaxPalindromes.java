package com.soulmeadows;

// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
public class MaxPalindromes {
    int count = 0;
    int start = 0;
    public int maxPalindromes(String s, int k) {

        for(int i = start; i < s.length(); ++i){
            helper(i, i, k, s);
            helper(i, i+1, k, s);
        }
        return count;
    }

    public void helper(int i, int j, int k, String s) {

        while(i >= start && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) break;
            if(j - i + 1 >= k ){
                ++count;
                start = j + 1;
                break;
            }
            ++j;
            --i;
        }
    }
}

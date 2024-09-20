package com.soulmeadows;
//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome_2 {
    public boolean validPalindrome(String s) {
        int[] table = new int[26];
        for(var c: s.toCharArray()){
            table[c - 'a']++;
        }
        int ones = 0;
        for(var count: table){
            if(count == 1){
                ++ones;
            }
        }
        return ones <= 2;
    }
    public static void main(String[] args){
        System.out.println(new ValidPalindrome_2().validPalindrome("aba"));
    }
}

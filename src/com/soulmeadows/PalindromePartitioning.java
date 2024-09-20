package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        var result = new ArrayList<List<String>>();
        backTrack(result, new ArrayList<String>(), s, 0);
        return result;
    }

    void backTrack(List<List<String>> result, List<String> currentList, String s, int start){
        if(start >= s.length()){
            result.add(new ArrayList<String>(currentList));
        }
        for(int end = start; end < s.length(); ++end){
            if(isPalindrome(s, start, end)){
                currentList.add(s.substring(start, end + 1));
                backTrack(result, currentList, s, end + 1);
                currentList.remove(currentList.size() -1);
            }
        }
    }
    boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){

        var solution = new PalindromePartitioning();
        var result = solution.partition("aab");
        for(var ele: result){
            for(var item: ele){
                System.out.print(item);
            }
            System.out.println();
        }

    }
}

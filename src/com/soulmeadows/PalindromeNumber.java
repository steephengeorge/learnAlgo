package com.soulmeadows;

import java.util.ArrayList;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        var arr = new ArrayList<Integer>();
        while(x > 0){
            arr.add(x%10);
            x /= 10;
        }
        int n = arr.size();
        for(int i = 0; i < n/ 2; ++i){
            if(arr.get(i) != arr.get(n - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        System.out.println(isPalindrome(1001));
    }
}

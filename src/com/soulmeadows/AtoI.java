package com.soulmeadows;

public class AtoI {

    public static int myAtoi(String s) {
        int  sign = 1;
        int index = 0;
        int n = s.length();
        int result = 0;
        while(index < n && s.charAt(index) == ' '){
            ++index;
        }
        if(index < n && s.charAt(index) == '-'){
            sign = -1;
            ++index;
        }else if(index < n && s.charAt(index) == '+'){
            ++index;
            sign = 1;
        }
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if(result > Integer.MAX_VALUE/ 10 ||(result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE %10)){
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            ++index;
        }
        return result * sign;
    }
    public static void main(String[] arsg){
        System.out.println(myAtoi("15"));
    }
}

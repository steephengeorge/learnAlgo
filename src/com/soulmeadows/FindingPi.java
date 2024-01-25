package com.soulmeadows;

public class FindingPi {

    public static double findPi(int n){
        double result = 1.0;
        int denominator = 3;
        boolean flag = true;
        for(int i = 2; i <= n; ++i ){
            if(flag == true){
                result = (result - (1/(double)denominator));
                flag = false;
                denominator += 2;
                continue;
            }
            result += 1/(double) denominator;
            flag = true;
            denominator +=2;
        }
        return 4*result;
    }

    public static void main(String[] args) {
        System.out.println(findPi(1));
        System.out.println(findPi(1000));
        System.out.println(findPi(10000));
        System.out.println(findPi(100000));
        System.out.println(findPi(1000000));
    }


}

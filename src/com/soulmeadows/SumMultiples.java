package com.soulmeadows;

public class SumMultiples {
    public static int sumOfMultiples(int n) {
        int sum = 0;
        int a = 3;
        while( a <= n){
            sum += 3;
            a += 3;
        }
        int b = 5;
        while(b <= n){
            if(b % 3 != 0){
                sum += b;
            }
            b += 5;
        }

        int c = 7;
        while(c <= n){
            if(c % 3 != 0 && c % 5 != 0){
                sum += c;
            }
            c += 7;
        }
        return sum;
    }

    public static void main(String[] args){

        System.out.println(sumOfMultiples(7));
    }
}

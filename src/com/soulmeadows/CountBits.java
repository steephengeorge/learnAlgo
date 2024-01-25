package com.soulmeadows;

public class CountBits {

    public static int count_Bits( int x) {
        int numBits = 0;
        while(x != 0) {
            ++numBits;
            x >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(count_Bits(8));
    }

}
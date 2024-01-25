package com.soulmeadows;

import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class BigNumberAdd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String size = in.nextLine();
        String str = in.nextLine();

        String[] strArray =  str.split(" ");


        BigInteger sum = BigInteger.ZERO;
        for(String strNum: strArray) {
            if(strNum.isEmpty())
                continue;
            sum = sum.add(BigInteger.valueOf(Long.parseLong(strNum)));
        }
        System.out.println(sum);
        in.close();
    }
}
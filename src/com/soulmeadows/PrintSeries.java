package com.soulmeadows;

import java.util.*;
import java.io.*;

/* We use the integers a, b, and n to create the following series: a+2^0 *b , a + 2^1 * b, ......a+2^n-1 *b

Print the series corresponding to the given a, b, n and values as a single line of space-separated integers.

Input Format

The first line contains an integer, t, denoting the number of queries. Each line of the subsequent lines contains three space-separated integers describing the respective a, b, n

Output Format

For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of space-separated integers.

Sample Input

2 0 2 10 5 3 5

Sample Output

2 6 14 30 62 126 254 510 1022 2046 8 14 26 50 98

*/
public class PrintSeries {
    static int[] findSum(int a, int b, int n){
        int result[] = new int[n];
        if( n >= 1){
            result[0] = a+b;
        }

        for( int j = 1; j < n; ++j){
            result[j] = result[j-1]+(int) Math.pow(2, j) * b;
        }
        return result;
    }
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            System.out.println(Arrays.toString(findSum(a, b, n)).replace("[","")
                    .replace("]","")
                    .replace(",",""));

        }
        in.close();
    }

}
package com;

import java.util.Scanner;

public class CachierRegister {
    public static void main(String[] args){
        Scanner input = args.length > 0? new Scanner(args[0]): new Scanner(System.in);
        while(input.hasNextLine()){
            System.out.println(processTransaction(input.next()));
        }
    }
    public static String processTransaction(String line){
        String[] transaction = line.split(",");
        double purchasePrice = Double.parseDouble(transaction[0]);
        double cash = Double.parseDouble(transaction[1]);

        if(purchasePrice > cash){
            return "ERROR";
        }
        if(purchasePrice == cash){
            return "ZERO";
        }
        double difference = cash - purchasePrice;
        return findCashChange(difference);
    }
    public enum Denomination{
        ONE_HUNDRED(100.00),
        FIFTY(50.00),
        TWENTY(20.00),
        TEN(10.00),
        FIVE(5.00),
        TWO(2.00),
        ONE(1.00),
        HALF_DOLLAR(0.50),
        QUARTER(0.25),
        DIME(0.10),
        NICKEL(0.05),
        PENNY(0.01);
        private double value;
        private String description;

        Denomination(double value){
            this.value = value;
            this.description = this.name().replace("_", " ");
        }
        public double getValue(){
            return this.value;
        }
        public String toString(){
            return this.description;
        }
    }
    public static String findCashChange(double difference){
        StringBuilder sb = new StringBuilder();
        for(var d: Denomination.values()){
            double value = d.getValue();
            while(difference >= value){
                sb.append(d).append(",");
                difference -= value;
            }
        }
        return sb.toString();
    }
}

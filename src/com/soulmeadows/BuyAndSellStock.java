package com.soulmeadows;

public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices) {
            int todaysProfit = price - minPrice;
            if(maxProfit < todaysProfit){
                maxProfit = todaysProfit;
            }
            if(minPrice > price){
                minPrice = price;
            }
        }
        return maxProfit;
    }
}

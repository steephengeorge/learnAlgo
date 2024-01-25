package com.soulmeadows;

import java.util.Arrays;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int hours){
        int minRate = 1;
        int maxRate = Arrays.stream(piles).max().getAsInt();
        int res = maxRate;
        while(minRate <= maxRate) {
            int rate = minRate + maxRate / 2;
            int time_needed = 0;
            for(var pile: piles){
                time_needed += Math.ceil(pile / rate);
            }
            if(time_needed <= hours) {
                res = Math.min(rate, res);
                maxRate -= 1;
            } else{
                minRate += 1;
            }
        }
        return res;
    }


}

package com.soulmeadows;

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int res = Integer.MIN_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long expected = mid *(mid + 1) / 2;
            if(expected > n){
                right = mid - 1;
            }else{
                left = mid + 1;
                res = Math.max(res, mid);
            }
        }
        return res;
    }

    public static void main(String[] args){
        var sol = new ArrangeCoins();
        sol.arrangeCoins(1804289383);
    }
}

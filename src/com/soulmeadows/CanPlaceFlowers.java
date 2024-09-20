package com.soulmeadows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanPlaceFlowers {
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        List<Integer> flower = Arrays.stream(flowerbed).boxed().collect(Collectors.toList());
//        flower.addFirst(0);
//        flower.addLast(0);
//        for(int i = 1; i <= flowerbed.length; ++i){
//            if(flower.get(i - 1) == 0 && flower.get(i) == 0 && flower.get(i + 1) == 0){
//                flower.set(i, 1);
//                --n;
//            }
//        }
//        return n <= 0;
//    }

    public static void main(String[] args){
        int[] nums = {1,0,0,0,1};
//        new CanPlaceFlowers().canPlaceFlowers(nums, 1);
    }
}

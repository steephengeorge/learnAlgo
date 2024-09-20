package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/baseball-game/
public class BaseBallGame {
    public int calPoints(String[] operations) {
        var rec = new ArrayList<Integer>();
        for(var op: operations){
            switch (op) {
                case "+":
                    int first = rec.get(rec.size() - 1);
                    int second = rec.get(rec.size() - 2);
                    rec.add(first + second);
                    break;
                case "D":
                    int sz = rec.size();
                    int current = rec.get(sz -1) * 2;
                    rec.add(current);
                    break;
                case "C":
                    sz = rec.size();
                    rec.remove(sz -1);
                    break;
                default:
                    int value =Integer.valueOf(op);
                    rec.add(value);
                    break;
            }
        }
        return rec.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args){
        String[] op = {"5","2","C","D","+"};
        new BaseBallGame().calPoints(op);
    }
}

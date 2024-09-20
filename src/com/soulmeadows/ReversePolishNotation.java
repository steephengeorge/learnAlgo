package com.soulmeadows;

import java.util.ArrayDeque;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();
        for(var token: tokens){
            switch(token){
                case "+":{
                    var second = stack.pop();
                    var first = stack.pop();
                    stack.push(first + second);
                }

                case "-":{
                    var second = stack.pop();
                    var first = stack.pop();
                    stack.push(first - second);
                }
                case "*":{
                    var second = stack.pop();
                    var first = stack.pop();
                    stack.push(first * second);
                }
                case "/":{
                    var second = stack.pop();
                    var first = stack.pop();
                    stack.push(first / second);
                }
                default:{
                    stack.push(Integer.valueOf(token));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        String[] input = {"2","1","+","3","*"};
        System.out.println(evalRPN(input));
    }
}

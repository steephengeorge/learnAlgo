package com.soulmeadows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthesis {
    public boolean isValid(String s) {
        var map = Map.of(')', '(', '}', '{', ']', '[');
        var stack = new ArrayDeque<Character>();
        for(var c: s.toCharArray()){
            if(map.containsKey(c)){
                var lastChar = stack.isEmpty()? '#': stack.pop();
                if(lastChar != map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

package com.soulmeadows;

import java.util.ArrayDeque;
import java.util.Deque;
// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthesis {
    boolean check(char c, Deque<Character> stack){
        if(!stack.isEmpty()){
            char value = stack.peek();
            if( value == c ){
                stack.pop();
                return true;
            }
        }
        return false;
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            switch(c){
                case '(':
                case '{':
                case '[':{
                    stack.push(c);
                    break;
                }
                case ')':
                    if(!check('(', stack)){
                        stack.push(c);
                    }
                    break;
                case '}':
                    if(!check('{', stack)) {
                        stack.push(c);
                    }
                    break;

                case ']':
                    if(!check('[', stack)){
                        stack.push(c);
                    }
                    break;


            }
        }
        return stack.isEmpty();

    }
}

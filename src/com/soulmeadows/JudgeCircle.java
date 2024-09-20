package com.soulmeadows;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(var c: moves.toCharArray()){
            switch(c){
                case 'R':
                    x += 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args){

        System.out.println(new JudgeCircle().judgeCircle("LLLLRULLRDDLDRRDLDRLDURLUUDRRLUDULURLLLLURUDRULDDLRLLLULLLLLULRUDRRRLDDLDLRULLDRUUDLRLDDURRUDRULLRLU"));
        System.out.println(new JudgeCircle().judgeCircle("R"));
        System.out.println(new JudgeCircle().judgeCircle("U"));
        System.out.println(new JudgeCircle().judgeCircle("D"));
        // LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
        // RRRRRRRRRRRRRRRRRRRRRRR
        // UUUUUUUUUUUUUUUUUUUU
        // DDDDDDDDDDDDDDDDDDDD
    }
}

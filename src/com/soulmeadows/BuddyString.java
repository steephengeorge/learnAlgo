package com.soulmeadows;

public class BuddyString {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        var sb = new StringBuilder(s);
        int i = 0;
        int j = 0;
        while(i < s.length() && j < goal.length()){
            if(s.charAt(i++) != goal.charAt(j++)){
                break;
            }
        }
        int k = i - 1;
        i = s.length() - 1;
        j = goal.length() - 1;
        while(i >= 0 && j >= 0){
            if(s.charAt(i--) != goal.charAt(j--)){
                break;
            }
        }
        int m = i + 1;
        swap(sb, k, m);
        return sb.toString().equals(goal);
    }
    private void swap(StringBuilder sb, int k, int l){
        var tmp = sb.charAt(k);
        sb.setCharAt(k, sb.charAt(l));
        sb.setCharAt(l, tmp);
    }

    public static void main(String[] args){

        System.out.println(new BuddyString().buddyStrings("ab", "ba"));
    }
}

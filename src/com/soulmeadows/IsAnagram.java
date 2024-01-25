package com.soulmeadows;

import java.util.Arrays;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        var s_str = s.chars().sorted().toArray();
        var t_str = t.chars().sorted().toArray();
        return Arrays.equals(s_str, t_str);
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "aangram"));
    }
}

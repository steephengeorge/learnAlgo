package com.soulmeadows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0){
            return List.of();
        }
        var map = new HashMap<Set<Character>, List<String>>();
        for(var str: strs){
            Set<Character> charSet = str.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
            if(map.containsKey(charSet)){
                var list =  map.get(charSet);
                list.add(str);
                map.put(charSet, list);
            }else{
                var list = new ArrayList<String>();
                list.add(str);
                map.put(charSet, list);
            }
        }
        var res = new ArrayList<List<String>>();
        for(var entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args){
        new GroupAnagrams().groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
    }
}

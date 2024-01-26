package com.soulmeadows;

import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/time-based-key-value-store/description/
class TimeMap {

    record Pair<Integer, String>(Integer key, String value) {

    }
    private HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;

    public TimeMap() {
        keyTimeMap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if(!keyTimeMap.containsKey(key)){
            keyTimeMap.put(key, new ArrayList());
        }
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!keyTimeMap.containsKey(key)) {
            return "";
        }
        if(timestamp < keyTimeMap.get(key).get(0).key()){
            return "";
        }
        int first = 0;
        int last = keyTimeMap.get(key).size();

        while( first < last){
            int mid = (first + last) / 2;
            if(keyTimeMap.get(key).get(mid).key() <= timestamp){
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        if(last == 0) {
            return "";
        }

        return keyTimeMap.get(key).get(last -1).value();
    }
}
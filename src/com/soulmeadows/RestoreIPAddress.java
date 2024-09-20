package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/description/
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        var res = new ArrayList<String>();
        if(s.length() > 12){
            return res;
        }
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int start, int dotsCount, StringBuilder sb , List<String> res){

        if(start == s.length() && dotsCount == 4){
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if(dotsCount > 4){
            return;
        }
        for(int i = start; i < Math.min(start + 3, s.length()); ++i){
            if(dotsCount > 5){
                continue;
            }
            var ele = s.substring(start, i + 1);
            if(Integer.valueOf(ele) <= 255 && (start == i || ele.charAt(0) != 0)){
                sb.append(ele);
                sb.append(".");
                backtrack(s, i + 1, dotsCount + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                sb.replace(sb.lastIndexOf(".") + 1, sb.length(), "");
            }

        }
    }
    public static void main(String[] args){
       var res = new RestoreIPAddress().restoreIpAddresses("25525511135");
    }
}

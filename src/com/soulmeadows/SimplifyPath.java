package com.soulmeadows;
// https://leetcode.com/problems/simplify-path/description/
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dires = path.split("/");
        var sb = new StringBuilder();

        for(int i = 0; i < dires.length; ++i){
            if(dires[i].equals("..")){
                if(i == 0){
                    continue;
                }
                sb.replace(sb.lastIndexOf(dires[i - 1]) - 1, sb.length(), "");
            }else if(dires[i].equals(".") || dires[i].equals("")){
                continue;
            }else{
                sb.append("/");
                sb.append(dires[i]);
            }
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args){
       // new SimplifyPath().simplifyPath("/home/user/Documents/../Pictures");

        new SimplifyPath().simplifyPath("/a/./b/../../c/");
    }
}

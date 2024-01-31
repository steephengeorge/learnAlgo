package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/gray-code/description/
// Check CircularPermutationGreyCode.java for notes
public class GreyCode {
    public List<Integer> grayCode(int n) {
        var list = new ArrayList<Integer>();
        for(int i = 0; i < 1 << n ; ++i){
            list.add(i^(i >> 1));
        }
        return list;
    }
}

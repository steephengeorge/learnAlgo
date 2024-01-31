package com.soulmeadows;

import java.util.ArrayList;
import java.util.List;
//  https://leetcode.com/problems/circular-permutation-in-binary-representation/
// https://cp-algorithms.com/algebra/gray-code.html
// https://www.youtube.com/watch?v=0dPN4gh0CKI&ab_channel=NesoAcademy
// https://www.youtube.com/watch?v=cF-Q5j7RUEw&ab_channel=NesoAcademy
public class CircularPermutationGreyCode {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i){ // 1<< n = 2^n
            // MSB should be intact for binary to grey code conversion so we do (i >> 1)
            // then we do exor with same number to get next grey code
            res.add(start ^ i ^ (i >> 1));
        }
        return res;
    }
}

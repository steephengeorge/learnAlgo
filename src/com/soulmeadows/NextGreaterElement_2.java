//https://leetcode.com/problems/next-greater-element-ii/description/

import java.util.HashMap;

public class NextGreaterElement_2 {

    public int[] nextGreaterElements(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], i);
            maxValue = Math.max(nums[i], maxValue);
        }

        int[] result = new int[nums.length];
        int j = 0;
        for(var num: nums){
            if(num == maxValue){
                result[j++] = -1;
                continue;
            }
            int index = map.get(num);
            boolean found = false;
            for(int i = index + 1; i < nums.length; ++i){
                if(num < nums[i]){
                    result[j++] = nums[i];
                    found = true;
                    break;
                }
            }
            if(!found){
                for(int i = 0; i <= index; ++i){
                    if(num < nums[i]){
                        result[j++] = nums[i];
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                result[j++] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
        new NextGreaterElement_2().nextGreaterElements(nums);
    }
}

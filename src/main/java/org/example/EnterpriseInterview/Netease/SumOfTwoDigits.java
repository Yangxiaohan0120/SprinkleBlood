package org.example.EnterpriseInterview.Netease;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-08-10 16:29
 **/

// 数组排序法行不通，排序后index改变

public class SumOfTwoDigits {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = new SumOfTwoDigits().twoSum(nums,target);
        System.out.println(res[0]);
    }
}

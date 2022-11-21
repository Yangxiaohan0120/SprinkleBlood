package org.example.AcWing;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-10-27 21:29
 **/
public class FastSlowNode {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3};
        System.out.println(findSum(nums));
    }

    public static int findSum(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        Arrays.sort(nums);
        int i = 0, j = 1;
        int sum = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[j]) {
                while(j < nums.length){
                    if(nums[i] != nums[j]){
                        break;
                    }else {
                        j++;
                    }
                }
            } else {
                sum += nums[i];
            }
            i = j;
            j = i + 1;
        }
        if(i == nums.length - 1){
            sum += nums[i];
        }
        return sum;
    }
}

package org.example.EnterpriseInterview.JD;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-08-11 09:28
 **/
public class ColorInArray {
    public void sortColors(int[] nums) {
        int n1 = 0, n2 = 0, n3 = 0;
        for(int num : nums){
            if(num == 0){
                n1 += 1;
            }else if(num == 1){
                n2 += 1;
            }else {
                n3 += 1;
            }
        }
        Arrays.fill(nums,0,n1,0);
        Arrays.fill(nums,n1,n2+n1,1);
        Arrays.fill(nums,n1+n2,nums.length,2);
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new ColorInArray().sortColors(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}

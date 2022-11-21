package org.example.AcWing;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chris Yang
 * created 2022-10-15 16:15
 **/
public class FindBiggesstNumberWithArrangeNum {
    public String printMinNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0 ; i < nums.length; i ++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

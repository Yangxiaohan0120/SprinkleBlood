package org.example.EnterpriseInterview.huawei;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chris Yang
 * created 2022-09-27 17:08
 **/
public class NumberArrange {

    public void sort(int[] nums,int N){
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.length() - 3;
                int j = o2.length() - 3;
                int a = -1;
                int b = -1;
                while(i < o1.length() && j < o1.length()){
                    if(i < 0 ){
                        a = 0;
                    }else{
                        a = o1.charAt(i) - '0';
                    }
                    if(j < 0){
                        b = 0;
                    }else{
                        b = o2.charAt(j) - '0';
                    }
                    if(a == b){
                        i++;
                        j++;
                    }else{
                        return a-b;
                    }
                }
                return 1;
            }
        });
        System.out.println(arr[N-1]);

     }

    public static void main(String[] args) {
        int[] nums = {2016,22,1223,3232};
        new NumberArrange().sort(nums,3);
    }
}

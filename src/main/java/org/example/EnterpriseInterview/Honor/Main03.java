package org.example.EnterpriseInterview.Honor;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-11 17:59
 **/
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] temps = temp.split(" ");
        int[] nums = new int[temps.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(temps[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length/2 ; i++) {
            int index = i;
            int count = 1;
            while(index < nums.length - 1){
                index += nums[index];
                count ++;
                if(index == nums.length - 1){
                    min = Math.min(min,count);
                }
            }
        }
        System.out.println(min);
    }
}

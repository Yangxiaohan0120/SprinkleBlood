package org.example.ShunFeng;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 18:43
 **/
public class Main04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0 ; i < n-1; i ++){
            int min = arr[i];
            int max = arr[i];
            for(int j = i + 1; j < n ; j ++){
                min = Math.min(min,arr[j]);
                max = Math.max(max,arr[j]);
                if(max == k * min)count ++;
            }
        }
        System.out.println(count);
    }
}

package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 20:20
 **/
public class ValidArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];

        for(int i = 0 ; i < n ; i ++){
            data[i] = sc.nextInt();
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = data[0];
        right[n-1] = data[n-1];

        int[] num = new int[n];
        int index = 1;
        for(int i = 1 ; i < n ; i ++){
            if(data[i] > left[index - 1]){
                num[i] = index;
                left[index++] = data[i];
            }else{
                int low  = 0,  high = index - 1;
                while(low < high){
                    int mid = (low + high) / 2;
                    if(left[mid] < data[i]){
                        low = mid + 1;
                    }else{
                        high = mid;
                    }
                }
                left[low] = data[i];
                num[i] = low;
            }
        }
        index = 1;
        for(int i = n - 2; i >= 0 ; i --){
            if(data[i] > right[index - 1]){
                num[i] += index;
                right[index++] = data[i];
            }else{
                int low  = 0,  high = index - 1;
                while(low < high){
                    int mid = (low + high) / 2;
                    if(right[mid] < data[i]){
                        low = mid + 1;
                    }else{
                        high = mid;
                    }
                }
                right[low] = data[i];
                num[i] += low;
            }
        }
        int max = 1;
        for(int number : num){
            max = Math.max(max,number);
        }
        System.out.println(n - max);
    }
}

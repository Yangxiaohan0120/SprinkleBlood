package org.example.EnterpriseInterview.ShunFeng;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 20:16
 **/
public class Station {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt()/ 100;
        int n = sc.nextInt();
        int[] e = new int[n];
        int[] t = new int[n];
        for(int i = 0 ; i < n ;i ++){
            e[i] = sc.nextInt()/100;
            t[i] = sc.nextInt();
        }


        int[] left = new int[n+1];
        for(int i = 1 ;i < n;i ++){
            left[i] = e[i] - e[i-1];
        }
        left[0] = e[0];
        left[n] = L - e[n-1];


        int[] battery = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            battery[i] = t[i-1];
        }

        System.out.println(findMin(left,battery,10-e[0],1,0));

    }

    public static int findMin(int[] e,int[] t,int L,int index,int count){
        if(L < 0){
            return Integer.MAX_VALUE;
        }
        if(index > e.length -1 )return count;
        // ³äµç
        int count1 = findMin(e,t,10-e[index],index+1,count + t[index]);
        // ²»³äµç
        int count2 = findMin(e,t,L-e[index],index+1,count);

        return Math.min(count1,count2);

    }
}

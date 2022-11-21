package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-27 21:32
 **/
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] q= new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        quickSort(q,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
    }

    public static void quickSort(int[] q, int l , int r){
        if(l >= r) return;

        int i = l-1,j = r+1,x = q[l + r >> 1];
        while(i < j){
            do i++; while(q[i] < x);
            do j--; while(q[j] > x);
            if(i < j) swap(q,i,j);
        }
        quickSort(q,l,j);
        quickSort(q,j+1,r);
    }

    public static void swap(int[] q,int a ,int b ){
        int t = q[a];
        q[a] = q[b];
        q[b] = t;
    }
}

package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-08-24 22:00
 **/
import java.util.Scanner;

public class TheKthNumber{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i ++){
            nums[i] = scanner.nextInt();
        }
        quickSort(nums,0,n-1,k);
    }

    public static void quickSort(int[] nums,int l,int r,int k){
        if(l < r){
            int v = partition(nums,l,r);
            if( v == k-1) System.out.println(nums[v]);
            if( v > k-1) quickSort(nums,l,v-1,k);
            else quickSort(nums,v+1,r,k);
        }
    }

    public static int partition(int[] nums,int l ,int r){
        int i = l,j = r + 1;
        int v = nums[l];

        while(true){
            while(nums[++i] < v){
                if(i == r)break;
            }
            while(nums[--j] > v){
                if(j == l)break;
            }
            if(i >= j)break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
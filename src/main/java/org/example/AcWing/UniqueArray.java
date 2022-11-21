package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-08-26 10:31
 **/
import java.util.Scanner;

public class UniqueArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i ++){
            nums[i] = sc.nextInt();
        }
        int[] res = new int[100001];
        int max = 0;
        for(int l = 0 , r = 0 ; r < n ; r ++){
            res[nums[r]] ++;
            while(l < r && res[nums[l]] > 1)res[nums[l++]] --;
            max = Math.max(max,r - l + 1);
        }
        System.out.println(max);
    }
}

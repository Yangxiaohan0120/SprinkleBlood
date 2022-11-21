package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-25 17:33
 **/
public class NumberRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int target = sc.nextInt();
            search(nums, 0, n - 1, target);
        }
    }

    public static void search(int[] nums, int l, int r, int target) {
        int i = l, j = r;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        if(nums[i] != target){
            System.out.println("-1 -1");
        }else {
            int left = i;
            i = l;
            j = r;
            while (i < j) {
                int mid = (i + j + 1) >> 1;
                if (nums[mid] <= target) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            }
            int right = i;
            System.out.print(left + " ");
            System.out.println(right);
        }
    }
}

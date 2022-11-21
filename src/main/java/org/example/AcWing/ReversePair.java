package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-25 17:15
 **/
public class ReversePair {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        mergeSort(nums, 0, n - 1);
        System.out.print(count);
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int[] temp = new int[r - l + 1];

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) temp[k++] = nums[j++];

        for (int m = l, n = 0; m <= r; m++, n++) {
            nums[m] = temp[n];
        }

    }
}

package org.example.EnterpriseInterview.Netease;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-08-10 18:36
 **/
public class HandyCandies {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1;
        }
        int sum1 = res[n-1];
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            sum1 += res[i];
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2};
        int res = new HandyCandies().candy(nums);
        System.out.println(res);
    }
}

package org.example.EnterpriseInterview.didi;

/**
 * @author Chris Yang
 * created 2022-08-12 19:53
 **/
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = Math.max(res[i-1] + nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n ; i++) {
            max = Math.max(res[i],max);
        }
        return max;
    }
}

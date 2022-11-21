package org.example.EnterpriseInterview.MIhayou;

/**
 * @author Chris Yang
 * created 2022-08-12 19:29
 **/
public class CommonString {



    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] res = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i-1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j-1];
                if(num1 == num2){
                    res[i][j] = res[i-1][j-1] + 1;
                }else {
                    res[i][j] = Math.max(res[i][j-1],res[i-1][j]);
                }
            }
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,2}, nums2 = {1,2,4};
        System.out.println(new CommonString().maxUncrossedLines(nums1,nums2));
    }
}

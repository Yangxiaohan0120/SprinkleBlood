package org.example.Leetcode;

/**
 * @author Chris Yang
 * created 2022-09-09 20:14
 **/
public class Buildings {
    public int[] findBuilding (int[] heights) {
        int[] res = new int[heights.length];

        for(int i = 0 ; i < res.length ; i ++){
            res[i] ++;
            if(i != 0){
                int max1 = res[i-1];
                res[i] ++;
                for(int m = i-2 ; m >= 0 ; m --){
                    if(heights[m] > max1){
                        res[i] ++;
                        max1 = heights[m];
                    }
                }
            }

            if(i != res.length - 1){
                res[i] ++;
                int max2 = res[i+1];
                for(int n = i+2 ; n < res.length ; n ++){
                    if(heights[n] > max2){
                        res[i] ++;
                        max2 = heights[n];
                    }
                }
            }
        }

        return res;
        // write code here
    }

    public static void main(String[] args) {
        int[] h = {50, 30, 80, 30, 27, 57};
        int[] res = new Buildings().findBuilding(h);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

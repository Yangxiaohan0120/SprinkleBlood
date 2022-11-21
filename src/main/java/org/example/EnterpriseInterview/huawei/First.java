package org.example.EnterpriseInterview.huawei;

/**
 * @author Chris Yang
 * created 2022-08-14 10:32
 **/
public class First {
    public String getPattern(String pattern) {
        int large = pattern.length() + 1;
        int[] res = new int[pattern.length() + 1];
        for(int i = 0 ; i < res.length; i ++){
            res[i] = 1;
        }

        int index = 0;
        int max = 1;
        for(int i = 0 ; i < pattern.length() ; i ++){
            char c = pattern.charAt(i);
            if(c == 'I'){
                res[i+1] = max + 1;
                max += 1;
                index = i+1;
            }else{
                for(int j = index ; j <= i; j ++){
                    res[j] ++;
                }
                res[i+1] = res[i] -1;
                max = res[index];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < res.length; i ++){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m-2][n-2];
//        for(int i = 1 ; i < m ; i ++){
//            for (int j = 0; j < n; j++) {
//                if(grid[i][j] > grid[res[i-1][j]][j]){
//                    res[i][j] = i;
//                }else if(grid[i][j] <= grid[res[i-1][j]][j] && i <= res[i-1][j] + 2){
//                    res[i][j] = res[i-1][j];
//                }else{
//
//                }
//            }
//        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                int max = grid[i][j];
                for (int k = i-1; k < i+2 ; k++) {
                    for (int l = j-1; l < j+2; l++) {
                        max = Math.max(max,grid[k][l]);
                    }
                }
                res[i-1][j-1] = max;
            }
        }
        return res;

    }

    public int edgeScore(int[] edges) {
        int[] res = new int[edges.length];
        for(int i = 0 ; i < edges.length; i ++){
            res[edges[i]] += i;
        }
        int max = Integer.MIN_VALUE;
        int n = -1;
        for(int i = 0 ; i < res.length; i ++){
            if(res[i] > max){
                n = i;
                max = res[i];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        String a = "abc";

        int[] nums = {1,0};
        int n = new First().edgeScore(nums);
        System.out.println(n);
    }
}

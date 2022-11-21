package org.example.Leetcode;

/**
 * @author Chris Yang
 * created 2022-09-07 14:18
 **/
public class MaxScore {
    public int maxScore (int energy, int[][] actions) {
        // write code here
        int[][] dp = new int[actions.length+1][energy+1];

        for(int i = 1 ; i < actions.length+1 ; i ++){
            for(int j = actions[i-1][0] ; j < energy + 1 ; j ++){
                // 选一次
                // 不选 dp[i-1][j];
                // 选一次
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j - actions[i-1][0]]);
            }
        }
        return dp[actions.length][energy];
    }

    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        long res = 1;
        while(decryption != 0){
            if(decryption % 2 == 1){
                res *= encryptedNumber;
            }
            encryptedNumber *= encryptedNumber;
            decryption >>= 1;
        }
        return (int) res % number;
    }

    public static void main(String[] args) {
        int energy = 10;
        int[][] actions = {{1,1},{2,3},{3,5},{5,10},{7,9},{8,10}};
        int res = new MaxScore().maxScore(energy,actions);
        System.out.println(res);
//
//        int encynumber = 4296;
//        int decy = 1601;
//        int num = 4757;
        int encynumber = 7;
        int decy = 15;
        int num = 3;
//        int res = new MaxScore().Decrypt(encynumber,decy,num);
//        System.out.println(res);
    }
}

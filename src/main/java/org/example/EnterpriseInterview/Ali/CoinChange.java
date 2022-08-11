package org.example.EnterpriseInterview.Ali;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-08-11 10:10
 **/
public class CoinChange {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        Arrays.sort(coins);
        coinsDes(coins,amount,coins.length-1,0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void coinsDes(int[] coins, int amount, int index,int count) {
        if(amount == 0){
            res = Math.min(res,count);
            return;
        }

        if(index < 0)return;;
        for(int i = amount/coins[index];i>=0 && i+count<res; i--){
            coinsDes(coins,amount - (i*coins[index]), index-1, count+i);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int res = new CoinChange().coinChange(coins,amount);
        System.out.println(res);
    }
}

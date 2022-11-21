package org.example.EnterpriseInterview.Ali;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-08-11 10:10
 **/
public class CoinChange {

    Map<Integer, Integer> map = new HashMap<>();

    // DP动态规划
    public int coinChange(int[] coins, int amount) {
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        if (amount == 0) return 0;

        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = coinChange(coins, amount - coin);
            if (subproblem == -1)
                continue;
            res = Math.min(res, 1 + subproblem);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        map.put(amount, res);
        return res;
    }

    // DFS 广度优先遍历
    int ans=Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0;c--){
            int na=amount-c*coins[index];
            int ncnt=cnt+c;
            if(na==0){
                ans=Math.min(ans,ncnt);
                break;//剪枝1
            }
            if(ncnt+1>=ans){
                break; //剪枝2
            }
            dfs(coins,index-1,na,ncnt);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = new CoinChange().coinChange1(coins, amount);
        System.out.println(res);
    }
}

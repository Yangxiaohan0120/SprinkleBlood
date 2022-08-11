package org.example.EnterpriseInterview.Netease;

/**
 * 使用动态规划解决股票购买问题
 *
 * @author Chris Yang
 * created 2022-08-10 15:58
 **/

// 遍历获取当前最小值和当前利益最大值

public class BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for(int price : prices){
            min = Math.min(price,min);
            maxProfit = Math.max(price-min,maxProfit);
        }
        return maxProfit;
    }
}

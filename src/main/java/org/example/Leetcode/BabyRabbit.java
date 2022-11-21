package org.example.Leetcode;

/**
 * @author Chris Yang
 * created 2022-09-09 19:26
 **/
public class BabyRabbit {

    public long calculateTotal (int count) {
        // write code here
        if(count < 3)return 1;
        long[] res = new long[count+1];
        res[0] = 1;
        res[1] = 0;
        res[2] = 0;
        // 获取到每个月出生的兔子（只有三个月之前的兔子可以生兔子）
        for(int i = 3 ; i <= count ; i ++){
            for(int j = i - 3 ; j >= 0 ; j --){
                res[i] += res[j];
            }
        }

        // 把每个月诞生的兔子相加
        long max = 0 ;
        for(int i = 0 ; i <= count ; i ++){
            max += res[i];
        }
        return max;

    }

    public static void main(String[] args) {
        int count = 6;
        long res = new BabyRabbit().calculateTotal(count);
        System.out.println(res);
    }
}

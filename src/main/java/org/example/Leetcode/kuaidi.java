package org.example.Leetcode;

/**
 * @author Chris Yang
 * created 2022-09-14 16:37
 **/
public class kuaidi {

    public int countOrders(int n) {
        int mod = 1000000007;

        long res = 1;
        for (int i = 1; i <= 2 * n; i++) {
            if(i % 2 == 1)res = res * i % mod;
            else res = i/2 * res % mod;
        }

        return (int) res % mod;
    }

    public static void main(String[] args) {
        int res = new kuaidi().countOrders(2);
        System.out.println(res);
    }
}

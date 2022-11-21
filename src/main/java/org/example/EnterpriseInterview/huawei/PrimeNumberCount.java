package org.example.EnterpriseInterview.huawei;

/**
 * @author Chris Yang
 * created 2022-09-27 10:14
 **/
public class PrimeNumberCount {
    public int findPrimeNumber(int n ){
        int res = 0;
        for (int i = 2; i <= n ; i++) {
            if(n % i == 0){
                n /= i;
                i--;
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new PrimeNumberCount().findPrimeNumber(120);
        System.out.println(res);
    }
}

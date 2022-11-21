package org.example.EnterpriseInterview.pdd;

/**
 * @author Chris Yang
 * created 2022-08-11 21:27
 **/
public class QuickPow {
    public double myPow(double x,int n){
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0){
            if((b & 1) == 1)res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

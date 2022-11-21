package org.example.EnterpriseInterview;

/**
 * @author Chris Yang
 * created 2022-10-20 14:41
 **/
public class Ball {

    public double[] findHeight(double n,int k){
        double res = 0;
        res += n;
        n /= 2;
        for (int i = 0; i < k; i++) {
            res += 2 * n;
            n /= 2;
        }
        return new double[]{res,n};
    }

    public static void main(String[] args) {
        double[] res = new Ball().findHeight(100,10);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

package org.example.Algorithm.Chapter1Basic;

/**
 * @author Chris Yang
 * created 2022-08-23 10:03
 **/
public class QuickSqrt {
    public static double sqrt(double c){
        if(c < 0)return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        double n = 5;
        double res = QuickSqrt.sqrt(n);
        System.out.println(res);
    }
}

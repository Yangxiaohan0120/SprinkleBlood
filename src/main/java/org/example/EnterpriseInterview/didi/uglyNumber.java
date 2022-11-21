package org.example.EnterpriseInterview.didi;

/**
 * @author Chris Yang
 * created 2022-08-12 20:10
 **/
public class uglyNumber {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < n; i++) {
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2,n3),n5);
            if(res[i] == n2)a++;
            if(res[i] == n3)b++;
            if(res[i] == n5)c++;
        }
        return res[n-1];
    }
}

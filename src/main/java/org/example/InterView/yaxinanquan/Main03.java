package org.example.InterView.yaxinanquan;

/**
 * @author Chris Yang
 * created 2022-10-16 18:53
 **/
public class Main03 {
    public int cal (int d, int[] array) {
        // write code here
        int n = array.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == i)continue;
                if(Math.abs(array[j] - array[i]) > d)continue;
                for (int k = 0; k < n; k++) {
                    if(k == j || k == i)continue;
                    if(Math.abs(array[k] - array[i]) > d)continue;
                    if(Math.abs(array[k] - array[j]) > d)continue;
                    res ++;
                }
            }
        }
        return res / 6;
    }
}

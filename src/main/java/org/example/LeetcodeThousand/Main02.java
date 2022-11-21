package org.example.LeetcodeThousand;

/**
 * @author Chris Yang
 * created 2022-09-04 10:29
 **/
public class Main02 {

    long count;

    public int numberOfWays(int startPos, int endPos, int k) {
        int m = Math.abs(endPos - startPos);

        if(k < m) return 0;
        if(k == m)return 1;
        if((k-m) % 2 == 1)return 0;
        int n = (k - m)/2;

        long res = Combination(k,n);

        return (int) res % 1000000007;

//        return (int) count % 1000000007;
    }

    public long Combination(int n ,int k){
        long a = 1,b =1;
        if(k > n/2){
            k = n-k;
        }

        for (int i = 1; i <= k ; i++) {
            a *= (n+1-i);
            b *= i;
        }

        return a/b;
    }

    public long Combination1(int n , int k ){
        if(k == 0 || k == n){
            return 1;
        }else {
            return Combination(n-1,k)+Combination(n-1,k-1);
        }
    }

    public void dfs(int index ,int end,int k){
        if(k == 0 && index == end ){
            count ++;
            return;
        }

        if(k == 0 && index != end)return;

        dfs(index+1,end,k-1);
        dfs(index-1,end,k-1);
    }

    public static void main(String[] args) {
        int res  = new Main02().numberOfWays(989,1000,99);
        System.out.println(res);

    }
}

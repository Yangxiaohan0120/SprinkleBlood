package org.example.HuaweiACM;

/**
 * @author Chris Yang
 * created 2022-08-23 21:57
 **/
public class TransferIP {
    public static void main(String[] args) {
        long res = 0;
        for (int i = 0; i < 4; i++) {
            res <<= 8;
            res += 255;
        }
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
        long n = 167773121;
        System.out.println(encode(n));
        String test = "10.0.3.193";
        System.out.println(decode(test));
    }


    public static long decode(String s){
        String[] arr = s.split("\\.");
        long res = 0;
        for(int i = 0; i < arr.length; i++){
            int t = Integer.parseInt(arr[i]);
            res <<= 8;
            res += t;
        }
        return res;
    }

    public static String encode(long s){
        long d = 1 << 8;
        long[] res = new long[4];
        for(int i = 3 ; i >= 0 ; i --){
            res[i] = s % d;
            s >>= 8;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 3 ; i ++){
            sb.append(res[i] + ".");
        }
        sb.append(res[3]);
        return sb.toString();
    }
}

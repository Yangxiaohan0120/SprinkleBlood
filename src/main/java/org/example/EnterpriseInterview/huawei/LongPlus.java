package org.example.EnterpriseInterview.huawei;

/**
 * @author Chris Yang
 * created 2022-09-27 10:17
 **/
public class LongPlus {
    public String addString(String a,String b){
        int m = a.length() -1;
        int n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while( n >= 0 || m >= 0){
            if (m >= 0) {
                carry += a.charAt(m) - '0';
            }
            if (n >= 0) {
                carry += b.charAt(n) - '0';
            }

            sb.append((char) (carry % 10 + '0'));
            carry /= 10;

            n--;
            m--;
        }

        if(carry == 1){
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "999999999";
        String b = "1";
        String res = new LongPlus().addString(a,b);
        System.out.println(res);
    }
}

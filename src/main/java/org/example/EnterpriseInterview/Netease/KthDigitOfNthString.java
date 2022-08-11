package org.example.EnterpriseInterview.Netease;

/**
 * @author Chris Yang
 * created 2022-08-10 16:42
 **/
public class KthDigitOfNthString {
    public char findKthBit(int n, int k) {
        String[] s = new String[20];
        s[0] = "0";
        for (int i = 1; i < 20; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s[i-1]);
            sb.append("1");
            sb.append(reverseInvert(s[i-1]));
            s[i] = sb.toString();
        }
        char res = s[n-1].charAt(k-1);
        System.out.println(s[19]);
        return res;
    }

    public String reverseInvert(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0'){
                sb.append('1');
            }else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new KthDigitOfNthString().findKthBit1(5,10));
        System.out.println();
    }

    public char findKthBit1(int n, int k) {
        int invertNum = 0;
        while(n > 1){
            int midPos =(int) Math.pow(2,n-1);
            if(midPos == k)return invertNum % 2 == 0 ? '1' : '0';
            if(k > midPos){
                k = midPos * 2 - k;
                invertNum ++;
            }
            n --;
        }
        return invertNum % 2 == 0 ? '0' : '1';
    }

}


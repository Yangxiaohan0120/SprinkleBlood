package org.example.AcWing;

/**
 * @author Chris Yang
 * created 2022-10-19 21:32
 **/
public class StringtoNumber {
    public boolean isNumber(String s) {
        int i = 0 ;
        while( i < s.length() && s.charAt(i) == ' ') i ++;
        int j = s.length() - 1;
        while( j >= 0 && s.charAt(j) == ' ') j--;
        if(i > j)return false;
        s = s.substring(i,j+1);

        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        if(s.isEmpty() || s.charAt(0) == '.' && s.length() == 1)return false;

        int dot = 0, e = 0;
        for (int k = 0; k < s.length(); k++) {
            if(s.charAt(k) >= '0' && s.charAt(k) <= '9')continue;
            else if(s.charAt(k) == '.') {
                dot ++;
                if(e > 1 || dot > 1) return false;
            }else if(s.charAt(k) == 'e' || s.charAt(k) == 'E'){
                e ++;
                if( k + 1 == s.length() || k == 0 || e > 1 || k == 1 && s.charAt(0) == '.')return false;
                if( s.charAt(k +1 ) == '+' || s.charAt(k + 1) == '-'){
                    if( k + 2 == s.length()) return  false;
                    k ++;
                }
            }else return false;

        }
        return true;
    }
}

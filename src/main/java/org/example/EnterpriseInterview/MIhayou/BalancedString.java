package org.example.EnterpriseInterview.MIhayou;

/**
 * @author Chris Yang
 * created 2022-08-12 10:20
 **/
public class BalancedString {
    public int balancedStringSplit(String s) {
        int d = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'L'){
                ++d;
            }else {
                --d;
            }
            if(d == 0){
                res += 1;
            }
        }
        return res;
    }
}

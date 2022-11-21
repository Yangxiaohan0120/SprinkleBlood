package org.example.EnterpriseInterview.yaxinanquan;

/**
 * @author Chris Yang
 * created 2022-10-16 18:53
 **/
public class Main01 {
    public boolean match(String string, String pattern) {
        // write code here
        // dpaaab d.a*b
        int m = string.length(), n = pattern.length();
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (index >= n) return false;
            if (index < n - 1 && pattern.charAt(index + 1) == '*') {
                int a = i;
                while (string.charAt(a) == pattern.charAt(index)) {
                    a++;
                }
                index += 2;
                if (a >= m && index >= n) return true;
                if (index >= n) return false;
                return match(string.substring(a, m), pattern.substring(index, n)) || match(string.substring(i, m), pattern.substring(index, n));
            } else if (pattern.charAt(index) == '.') {
                index++;
            } else if (string.charAt(i) != pattern.charAt(index)) {
                return false;
            } else index++;
        }
        if (index >= n){
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        String string = "ab";
        String pattern = "aba*";
        System.out.println(new Main01().match(string, pattern));
    }
}

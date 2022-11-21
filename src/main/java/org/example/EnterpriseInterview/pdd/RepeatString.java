package org.example.EnterpriseInterview.pdd;

/**
 * @author Chris Yang
 * created 2022-08-11 16:25
 **/
public class RepeatString {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new RepeatString().repeatedSubstringPattern(s));
    }
}

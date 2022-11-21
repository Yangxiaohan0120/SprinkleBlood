package org.example.EnterpriseInterview.yaxinanquan;

/**
 * @author Chris Yang
 * created 2022-10-16 18:53
 **/
public class Main02 {
    public String getLongestPalindrome(String geneticStr) {
        // write code here
        if (geneticStr.length() <= 1) return "-1";
        char[] arr = geneticStr.toCharArray();
        int n = geneticStr.length();
        int max = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (i - k >= 0 && i + k < n) {
                if (arr[i - k] == arr[i + k]) k++;
                else break;
            }
            if (2 * k - 1 > max) {
                max = 2 * k - 1;
                res = geneticStr.substring(i - k + 1, i + k);
            }
            k = 0;
            while (i - k >= 0 && i + k + 1 < n) {
                if (arr[i - k] == arr[i + k + 1]) k++;
                else break;
            }
            if (2 * k > max) {
                max = 2 * k;
                res = geneticStr.substring(i - k + 1, i + k + 1);
            }
        }
        if (res.length() == 1) {
            return "-1";
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        String geneticStr = "sjdaiwasdesdsffsdsedsaw1h3u238dsahji1";
        String res = new Main02().getLongestPalindrome(geneticStr);
        System.out.println(res);
    }
}

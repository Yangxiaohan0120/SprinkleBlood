package org.example.EnterpriseInterview.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-28 20:14
 **/
public class Strs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
//             String words = sc.nextLine();
//             String str1 = words.split(" ")[0];
//             String str2 = words.split(" ")[1];
            String str1 = sc.next();
            String str2 = sc.next();
            String res = findTimes(str1, str2);
            System.out.println(res);
        }
    }

    public static String findTimes(String a, String b) {
        if (a.length() != b.length()) {
            return "No";
        } else {
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                char m = a.charAt(i);
                char n = b.charAt(i);
                if (m != n) {
                    list1.add(m);
                    list2.add(n);
                }
            }

            if (list1.size() == 0) {
                return "Yes";
            } else if (list1.size() == 2) {
                if (list1.get(0) == list2.get(1) && list1.get(1) == list2.get(0)) {
                    return "Yes";
                } else {
                    return "No";
                }
            } else {
                return "No";
            }
        }
    }
}

package org.example.InterView.webank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i)-'0' > o2.charAt(i) - '0'){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                }
                return o2.length() - o1.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        if(n < 3){
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
            }
        }else{
            String[] temp = Arrays.copyOf(arr,3);
            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int n = Math.min(o1.length(),o2.length());
                    for (int i = 0; i < n; i++) {
                        if(o1.charAt(i)-'0' > o2.charAt(i) - '0'){
                            return -1;
                        }else if(o1.charAt(i) - '0' < o2.charAt(i) - '0'){
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            for (int i = 0; i < 3; i++) {
                sb.append(temp[i]);
            }
        }
        System.out.println(sb.toString());
    }

}

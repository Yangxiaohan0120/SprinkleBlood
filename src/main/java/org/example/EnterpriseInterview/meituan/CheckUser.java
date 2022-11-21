package org.example.EnterpriseInterview.meituan;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-12 21:11
 **/
public class CheckUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int count1 = 0;
            int count2 = 0;
            char c = name.charAt(0);
            if ((c <= 'A' || c >= 'Z') || (c <= 'a' && c >= 'z')) {
                System.out.println("Wrong");
                continue;
            } else {
                boolean res = true;
                for (int j = 1; j < name.length() && res; j++) {
                    c = name.charAt(j);
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                        count1 += 1;
                    } else if (c >= '0' && c <= '9') {
                        count2 += 1;
                    } else {
                        System.out.println("Wrong");
                        res = false;
                    }
                }
            }
            if (count1 == 0 || count2 == 0){
                System.out.println("Wrong");
            }else {
                System.out.println("Accept");
            }
        }

        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test(){
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                if (s.length() < 2 || !Character.isLetter(s.charAt(0))) {
                    System.out.println("Wrong");
                    continue;
                }
                boolean hasLetter = false;
                boolean hasDigit = false;
                boolean hasOther = false;
                for (char c : s.toCharArray()) {
                    if (Character.isLetter(c)) {
                        hasLetter = true;
                    } else if (Character.isDigit(c)) {
                        hasDigit = true;
                    } else {
                        hasOther = true;
                        break;
                    }
                }
                if (hasLetter && hasDigit && !hasOther)
                    System.out.println("Accept");
                else
                    System.out.println("Wrong");
            }
        }
    }
}

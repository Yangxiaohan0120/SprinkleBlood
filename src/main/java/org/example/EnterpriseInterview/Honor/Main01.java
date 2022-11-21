package org.example.EnterpriseInterview.Honor;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-11 17:59
 **/

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int index = 0;
        while (!strs[index].equals("5a")) {
            index ++;
        }
        int count = 0;
        if(index != strs.length - 1){
            System.out.print("5a ");
        }
        index++;
        int i = index;
        while (i < strs.length) {
            if (strs[i].equals("5b") && i < strs.length - 1) {
                if (strs[i + 1].equals("bb") || strs[i + 1].equals("ba")) {
                    count ++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            } else if (strs[i].equals("5a") && i > index) {
                if (count - 1 == getNumber(strs[i - 1])) {
                    for (int j = index; j <= i; j++) {
                        System.out.print(strs[j] + " ");
                    }
                    count = 0;
                    i++;
                } else {
                    index = i+1;
                    i = index;
                    count = 0;
                }
            } else {
                count ++;
                i++;
            }

        }
//        System.out.println(Main01.getNumber("16"));
    }

    public static int getNumber(String val) {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            count *= 16;
            char a = val.charAt(i);
            if (Character.isDigit(a)) {
                count += (int) (a - '0');
            } else {
                count += (int) (a - 'a') + 10;
            }

        }
        return count;
    }



}

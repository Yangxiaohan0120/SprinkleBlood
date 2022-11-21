package org.example.EnterpriseInterview.ShunFeng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-31 20:17
 **/
public class words {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        String sen = sc.nextLine();
        String word = sc.nextLine();

        String[] words = word.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(Character.toLowerCase(words[i].charAt(j)));
            }
            map.put(sb.toString(), i);
        }

        int count = 0;
        StringBuilder res = new StringBuilder();
        String[] sens = sen.split(" ");
        for (int i = 0; i < sens.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (sens[i].equals("\"")) {
                count += 1;
                res.append(sens[i]).append(" ");
            } else {
                for (int j = 0; j < sens[i].length(); j++) {
                    sb.append(Character.toLowerCase(sens[i].charAt(j)));
                }
                String temp = sb.toString();
                if (map.containsKey(temp) && count % 2 == 0) {
                    res.append(map.get(temp)).append(" ");
                } else {
                    res.append(sens[i]).append(" ");
                }
            }
        }

        System.out.println(res.toString().replaceAll("\\s+$", ""));
    }
}

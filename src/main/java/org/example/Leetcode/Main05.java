package org.example.Leetcode;

/**
 * @author Chris Yang
 * created 2022-09-04 15:48
 **/

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

public class Main05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, ArrayList> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int num = sc.nextInt();
            int value = sc.nextInt();
            if (map.containsKey(num)) {
                ArrayList list = map.get(num);
                list.add(value);
                map.put(num, list);
            } else {
                ArrayList list = new ArrayList();
                list.add(value);
                map.put(num, list);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(map.get(arr[i]) == null){
                count += findFactor(arr[i]).size();
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                int multi = arr[i];
                HashSet<Integer> set = new HashSet<>();
                for(int num : list){
                    set.addAll(findFactor(num));
                    multi *= num;
                }
                set.addAll(findFactor(multi));
                count += set.size();
            }
        }
        System.out.println(count);
    }


    public static HashSet<Integer> findFactor(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(n);
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                set.add(i);
            }
        }
        return set;
    }

}
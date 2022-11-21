package org.example.zijie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-09 10:01
 **/
public class TheShortestLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] len = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for (int i = 0; i < n; i++) {
            len[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (len[i] > i) {
                System.out.println("-1");
                return;
            }
            if (map.containsKey(len[i])) {
                list = map.get(len[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i + 1);
            map.put(len[i], list);
        }

        for (int i = 1; i < n; i++) {
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    if (map.containsKey(i - 1)) {
                        System.out.println(map.get(i - 1).get(0) + " " + map.get(i).get(j));
                    } else {
                        int index = i-1;
                        while(index >= 0){
                            if(map.containsKey(index) && map.get(index).size() >= i-index){
                                break;
                            }else{
                                index --;
                            }
                        }
                        if(index < 0){
                            System.out.println("-1");
                            return;
                        }else{
                            for(int m = 0 ; m < i - index - 1; m ++){
                                System.out.println(map.get(index).get(m)+" "+map.get(index).get(m+1));
                            }
                            System.out.println(map.get(index).get(i - index - 1) + " " + map.get(i).get(j));
                        }
                    }
                }
            } else continue;
        }
    }


}

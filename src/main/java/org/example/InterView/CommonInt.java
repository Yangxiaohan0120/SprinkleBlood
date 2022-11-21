package org.example.InterView;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-10-05 20:29
 **/
public class CommonInt {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        b.add(1);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);
        new CommonInt().findCommon(a, b);
    }

    public void findCommon(List<Integer> a, List<Integer> b) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            set.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            if(set.contains(b.get(i)) && map.containsKey(b.get(i))){
                map.put(b.get(i),map.get(b.get(i)) + 1);
            }else if(set.contains(b.get(i)) && !map.containsKey(b.get(i))){
                map.put(b.get(i),1);
            }
        }
        int i = 0;
        int[] arr = new int[map.keySet().size()];
        for(int num : map.keySet()){
            arr[i] = num;
            i++;
        }
        Arrays.sort(arr);
        int m = 5;
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < map.get(arr[j]); k++) {
                if(m > 0){
                    System.out.println(arr[j]);
                }
                m --;
                if(m <= 0 )break;
            }
            if(m <= 0 )break;
        }
    }
}

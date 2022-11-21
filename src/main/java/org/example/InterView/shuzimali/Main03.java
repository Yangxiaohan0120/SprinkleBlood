package org.example.InterView.shuzimali;

/**
 * @author Chris Yang
 * created 2022-10-15 17:51
 **/
import javafx.util.Pair;

import java.util.*;

public class Main03{

    static int res = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0 ; i < n ; i ++){
            a[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i ++){
            b[i] = sc.nextInt();
        }

        ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
            if(map.containsKey(a[i])){
                List list1 = map.get(a[i]);
                list1.add(new Pair<>(a[i],b[i]));
                map.put(a[i],list1);
            }else{
                List list1 = new ArrayList();
                list1.add(new Pair<>(a[i],b[i]));
                map.put(a[i],list1);
            }
        }
        for(int x : set){
            int count = 3;
            List list1 = map.get(x);
            for (int i = 0; i < list1.size(); i++) {
            }
        }

    }
}
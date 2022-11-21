package org.example.liping;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-11-10 16:45
 **/
public class Main01 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        Arrays.stream(a).sum();
        Random random = new Random(10);
        random.nextInt();

        int n = 8000;
        HashSet<Integer> set = new HashSet<>();
        while(set.size() < n){
            int i = random.nextInt();
            set.add(i);
        }



    }
}

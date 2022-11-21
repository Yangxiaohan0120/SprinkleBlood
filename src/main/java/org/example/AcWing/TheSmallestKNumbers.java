package org.example.AcWing;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-10-11 17:43
 **/
public class TheSmallestKNumbers {
    public List<Integer> getLeastNumbers_Solution(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int x : input){
            pq.add(x);
            if(pq.size() > k){
                pq.poll();
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll());
        }
        return res;
    }
}

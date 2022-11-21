package org.example.AcWing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-08 19:43
 **/
public class Zipfiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        PriorityQueue<Long> q = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1 >= o2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        long total = 0;
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            total += a;
            q.add(a - b);
        }

        long target = total - m;

        int count = 0;
        while(!q.isEmpty()){
            if(target > 0){
                target -= q.poll();
                count ++;
            }else{
                break;
            }
        }

        if(target > 0)System.out.println("-1");
        else System.out.println(count);
    }
}

package org.example.EnterpriseInterview.ShunFeng;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-08-31 15:34
 **/
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] e = new long[n+1];
        int[] root = new int[n+1];

        root[1] = 0;
        for (int i = 2; i <= n ; i++) {
            root[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= n ; i ++){
            e[i] = sc.nextLong();
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = 0 ;
        queue.add(1);

        HashSet<Integer> set = new HashSet<>();
        while(!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 2; i <= n; i++) {
                if(set.contains(i))continue;
                else if(root[i] == num){
                    count += Math.abs(e[i]);
                    e[1] -= e[i];
                    queue.add(i);
                    set.add(i);
                }
            }
        }
        count += Math.abs(e[1]);
        System.out.println(count);

    }
}


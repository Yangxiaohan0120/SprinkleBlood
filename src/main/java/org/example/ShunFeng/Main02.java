package org.example.ShunFeng;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-08-31 15:34
 **/
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] e = new long[n + 1];
        int[] root = new int[n + 1];

        root[1] = 0;
        for (int i = 2; i <= n; i++) {
            root[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            e[i] = sc.nextLong();
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        queue.add(1);

        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 2; i <= n; i++) {
                if (set.contains(i)) continue;
                else if (root[i] == num) {
                    if (e[i] - e[num] > 0 && e[num] > 0) {
                        e[num] = Math.max(Math.abs(e[i]), Math.abs(e[num]));
                    } else if (e[num] < 0) {
                        e[num] = Math.min(Math.abs(e[i]), Math.abs(e[num]));
                    } else {
                        e[num] = Math.abs(e[num] - e[i]);
                    }
                    queue.add(i);
                    set.add(i);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (root[i] == 1) {
                count += Math.abs(e[i]);
                e[1] -= e[i];
            }
        }

        count += Math.abs(e[1]);
        System.out.println(count);

    }
}


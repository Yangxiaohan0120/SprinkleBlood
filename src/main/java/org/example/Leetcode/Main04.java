package org.example.Leetcode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Chris Yang
 * created 2022-09-04 10:29
 **/
public class Main04 {
    public int mostBooked(int n, int[][] meetings) {
        int[] start = new int[meetings.length];
        int[] end = new int[meetings.length];
        int[] times = new int[n];
        PriorityQueue<MyPair> queue = new PriorityQueue<>(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                if(o1.end == o1.end){
                    return o1.index - o1.index;
                }
                return o1.end - o2.end;

            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            queue.add(new MyPair(meetings[i][0], meetings[i][1], i));
            map.put(i, 1);
        }

        for (int i = n; i < meetings.length; i++) {
            MyPair now = queue.poll();
            map.put(now.index, map.get(now.index) + 1);
            now.start = now.end;
            now.end += meetings[i][1] - meetings[i][0];
            queue.add(new MyPair(now.start, now.end, now.index));
        }

        int max = 0;
        int res = 0;
        for (int m : map.keySet()) {
            if (map.get(m) > max) {
                res = m;
                max = map.get(m);
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
//        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int[][] meetings =
                {{0, 10}, {1, 5}, {2, 7}, {3, 4}};
        int res = new Main04().mostBooked(2, meetings);
        System.out.println(res);
    }

}

class MyPair {
    int start;
    int end;
    int index;

    public MyPair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-03 19:46
 **/
public class nk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int m = sc.nextInt();
        Pair[] list = new Pair[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[i] = new Pair(a, b);
        }
        sort(list);
        int n = 1;
        int r = list[m-1].x2;
        int l = list[m-1].x1;
        for(int i = m-2 ; i >= 0 ; i --){
            if(list[i].x2 >= l){
                l = Math.min(list[i].x1,l);
            }else{
                n += 1;
                l = list[i].x1;
                r = list[i].x2;
            }
        }
        System.out.println(n);

    }

    public static void sort(Pair[] list) {
        int n = list.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list[i].x2 > list[j].x2) {
                    swap(list, i, j);
                } else if (list[i].x1 > list[j].x1) {
                    swap(list, i, j);
                }
            }
        }
    }

    public static void swap(Pair[] list, int a, int b) {
        int t1 = list[a].x1;
        int t2 = list[a].x2;
        list[a].x1 = list[b].x1;
        list[a].x2 = list[b].x2;
        list[b].x1 = t1;
        list[b].x2 = t2;
    }
}

class Pair {
    int x1;
    int x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

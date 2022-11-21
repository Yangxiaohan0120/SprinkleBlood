package org.example.AcWing;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-30 22:07
 **/
public class ListByArray {


    static int head = -1; // ��¼��һ���ڵ��ָ��
    static int N = 100010;
    static int[] e = new int[N]; // �洢Ԫ�ص�ֵ
    static int[] ne = new int[N]; // �洢Ԫ����һ���ڵ��ָ��
    static int idx = 0; // �洢��ǰ��ָ��


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String c = sc.next();
            if (c.equals("H")) {
                int x = sc.nextInt();
                insertHead(x);
            } else if (c.equals("I")) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                insert(k - 1, x);

            } else if (c.equals("D")) {
                int k = sc.nextInt();
                if (k == 0) {
                    head = ne[head];
                } else {
                    delete(k - 1);
                }
            }
        }

        int i = head;
        while (i != -1) {
            System.out.print(e[i] + " ");
            i = ne[i];
        }
    }

    public static void insertHead(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public static void delete(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }
}

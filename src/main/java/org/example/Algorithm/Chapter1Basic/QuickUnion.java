package org.example.Algorithm.Chapter1Basic;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 10:31
 **/
public class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            int N = in.nextInt();
            QuickFind quickFind = new QuickFind(N);
            while (in.hasNext()) {
                int p = System.in.read();
                int q = System.in.read();
                if (quickFind.connected(p, q)) {
                    continue;
                }
                quickFind.union(p, q);
                System.out.println(p + " " + q);
            }
            System.out.println(quickFind.count() + "components");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

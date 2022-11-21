package org.example.Algorithm.Chapter1Basic;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 10:21
 **/
public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    public int find(int n){
        return id[n];
    }

    public void union(int p , int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)return;
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID) id[i] = qID;
        }
        count --;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){

            int N = in.nextInt();
            QuickFind quickFind = new QuickFind(N);
            while(in.hasNext()) {
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

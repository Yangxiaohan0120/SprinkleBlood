package org.example.LeetcodeThousand;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-04 16:13
 **/
public class MaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            int num = queue.poll();
            queue.add(num - x);
        }

        System.out.println(queue.peek());
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

}

class Maxheap{

    Node head;

    public void add(Node node,int n){
        if(node == null){
            node.value = n;
        }else if(node.value < n){
            add(node.right,n);
        }else{
            add(node.left,n);
        }
    }

    public void add(int n){
        add(head,n);
    }


}

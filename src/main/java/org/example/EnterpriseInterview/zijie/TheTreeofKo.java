package org.example.EnterpriseInterview.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-10-09 10:04
 **/
public class TheTreeofKo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list.add(new Node(i+1));
        }
        for (int i = 0; i < nums.length; i++) {
            int min = Math.min(nums[i][0],nums[i][1]);
            int max = Math.max(nums[i][0],nums[i][1]);
            list.get(max-1).parent = list.get(min-1);
            if(list.get(min-1).child1 != null){
                list.get(min-1).child1 = list.get(max-1);
            }else{
                list.get(min-1).child2 = list.get(max-1);
            }
        }

        Node root = list.get(0);

    }
}

class Node{
    int value;
    Node parent;
    Node child1;
    Node child2;

    Node(int v){
        this.value = v;
    }

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

}

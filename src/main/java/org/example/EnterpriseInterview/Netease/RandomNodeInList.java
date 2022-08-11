package org.example.EnterpriseInterview.Netease;

import java.util.List;
import java.util.Random;

/**
 * @author Chris Yang
 * created 2022-08-10 16:05
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// 只能遍历一次，最后一个数返回的概率是1/n
// 前一个数是 （n-1)/n * 1/(n-1) = 1/n
// 有不断被覆盖的机会

public class RandomNodeInList {
    private ListNode head;
    private Random random;


    public RandomNodeInList(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int ans = 0;
        ListNode p = head;
        for (int cnt = 1; p != null; cnt++, p = p.next){
            if (random.nextInt(cnt) == 0) ans = p.val;
        }
        return ans;
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 5000; i++) {
//            Random random = new Random();
//            int a = random.nextInt(1);
//            System.out.println(a);
//        }

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        for (int i = 0; i < 30; i++) {
            System.out.println(new RandomNodeInList(head).getRandom());
        }
    }

}

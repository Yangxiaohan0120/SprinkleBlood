package org.example.EnterpriseInterview.Ali;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Chris Yang
 * created 2022-08-11 11:09
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        for (ListNode node : lists) {
            if(node != null)queue.add(node);
        }
        while( !queue.isEmpty()){
            head.next = queue.poll();
            head = head.next;
            if(head.next != null)queue.add(head.next);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{node1,node2,node3};

        ListNode head =  new MergeKSortedList().mergeKLists(lists);
    }
}

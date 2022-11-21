package org.example.EnterpriseInterview.Bilibili;

/**
 * @author Chris Yang
 * created 2022-08-11 15:01
 **/


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 找到中点
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 获取两个链表，记得断开
        ListNode newHead = reverse(slow.next);
        slow.next = null;

        // 将新链表依次插入
        ListNode cur = head;
        while(newHead != null){
            ListNode temp = newHead.next;
            newHead.next = cur.next;
            cur.next = newHead;
            cur = newHead.next;
            newHead = temp;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new ReorderList().reorderList(node1);
    }
}

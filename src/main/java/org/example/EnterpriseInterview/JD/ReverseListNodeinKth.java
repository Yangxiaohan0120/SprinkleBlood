package org.example.EnterpriseInterview.JD;

import java.util.List;

/**
 * @author Chris Yang
 * created 2022-08-11 09:46
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

public class ReverseListNodeinKth {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            pre.next = reverse[0];
            reverse[1].next = next;
            head = next;
            pre = reverse[1];
        }
        return dummyHead.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}

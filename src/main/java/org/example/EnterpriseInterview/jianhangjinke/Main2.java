package org.example.EnterpriseInterview.jianhangjinke;


/**
 * @author Chris Yang
 * created 2022-10-29 18:54
 **/

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}

public class Main2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode reverseList (ListNode head) {
        // write code here
        if(head == null || head.next == null)return head;
        if(head.next.next == null){
            if(head.val == head.next.val)return head;
            else{
                ListNode next = head.next;
                next.next = head;
                head.next = null;
                return next;
            }
        }
        ListNode dummyHead = new ListNode(0);

        ListNode pre = dummyHead;
        ListNode cur = head;
        pre.next = head;
        ListNode next = cur.next;
        while(next != null && next.next != null){
            if(cur.val != next.val && next.val != next.next.val){
                ListNode first = cur;
                ListNode first1 = next;
                if(pre == dummyHead){
                    first = pre;
                    first1 = cur;
                }
                while(next != null && cur.val != next.val){
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    next = next.next;
                }
                if(next == null){
                    cur.next = pre;
                    first.next = cur;
                    first1.next = next;
                }else{
                    first.next = pre;
                    first1.next = cur;
                }
            }
            pre = cur;
            cur = next;
            if(cur == null){
                break;
            }else{
                next = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(3);
        ListNode head7 = new ListNode(3);
        ListNode head8 = new ListNode(3);
        ListNode head9 = new ListNode(4);
        ListNode head10 = new ListNode(5);
//        head.next = head1;
//        head1.next = head2;
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;
        head8.next = head9;
        head9.next = head10;
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
        ListNode res = new Main2().reverseList(head);
        while(res != null){
            System.out.print(res.val + " -> ");
            res = res.next;
        }

    }
}

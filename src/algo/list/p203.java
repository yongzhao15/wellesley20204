package algo.list;

import common.ListNode;
import common.ListUtils;

public class p203 {
    public static void main(String[] args) {
        ListNode head = ListUtils.newList(10, 1, 1);
        System.out.println(ListUtils.dumpList(head));

        p203 p = new p203();

        head = p.removeElements(head, 1);
        System.out.println(ListUtils.dumpList(head));

        head = p.removeElements(head, 10);
        System.out.println(ListUtils.dumpList(head));

        head = p.removeElements(head, 5);
        System.out.println(ListUtils.dumpList(head));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode head2 = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            if (cur.val != val) {
                if (prev == null) {
                    head2 = cur;
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }

        if (prev != null) {
            prev.next = null;
        }

        return head2;
    }
}

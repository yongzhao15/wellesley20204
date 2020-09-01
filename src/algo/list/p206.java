package algo.list;

import common.ListNode;
import common.ListUtils;

public class p206 {
    public static void main(String[] args) {
        ListNode head = ListUtils.newList(10, 1, 1 );
        System.out.println(ListUtils.dumpList(head));

        p206 p = new p206();
        head = p.reverseList(head);
        System.out.println(ListUtils.dumpList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr= next;
        }

        return prev;
    }
}

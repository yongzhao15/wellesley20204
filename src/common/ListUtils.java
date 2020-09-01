package common;

import common.ListNode;

public class ListUtils {
    public static ListNode newList(int sz, int start, int step) {
        if (sz == 0) { return null; }
        ListNode head = new ListNode(start);
        ListNode cur = head;
        for(int i = 2; i <= sz; i++) {
            cur.next = new ListNode(cur.val + step);
            cur = cur.next;
        }
        return head;
    }

    public static String dumpList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return sb.toString();
        }

        ListNode cur = head;
        sb.append(cur.val);
        cur = cur.next;
        while(cur != null) {
            sb.append(String.format(" -> %d", cur.val));
            cur = cur.next;
        }

        return sb.toString();
    }
}

package algo.list;

import common.ListNode;
import common.ListUtils;

public class p445 {
    public static void main(String[] args) {
        p445 p =  new p445();
        ListNode l1 = ListUtils.newList(new int[] {7,2,4,3});
        ListNode l2 = ListUtils.newList(new int[] {5,6,4});
        System.out.println(ListUtils.dumpList(p.addTwoNumbers(l1,l2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        int len1 = getLen(l1);
        int len2 = getLen(l2);
        ListNode res = len1 > len2 ? addList2(l1, len1, l2, len2) : addList2(l2, len2, l1, len1);
        if (res.val >= 10) {
            ListNode nxt = res;
            res = new ListNode(nxt.val / 10);
            nxt.val = nxt.val % 10;
            res.next = nxt;
        }
        return res;
    }

    private ListNode addList2(ListNode l1, int len1, ListNode l2, int len2) {
        if (len1 == 0) { return null; }
        if (len1 == 1 && len2 == 1) {
            return new ListNode(l1.val + l2.val);
        }

        ListNode res = null;
        if (len1 > len2) {
            res = new ListNode(l1.val);
            res.next = addList2(l1.next, len1-1, l2, len2);
        } else { // len1 == len2
            res = new ListNode(l1.val + l2.val);
            res.next = addList2(l1.next, len1-1, l2.next, len2 - 1);
        }

        res.val = res.val + res.next.val / 10;
        res.next.val = res.next.val % 10;
        return res;
    }

    private int getLen(ListNode l) {
        if (l == null) { return 0; }

        int len = 0;
        ListNode cur = l;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}

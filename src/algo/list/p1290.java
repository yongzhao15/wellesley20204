package algo.list;

import common.ListNode;
import common.ListUtils;

public class p1290   {
    public static void main(String[] args) {
        p1290 p = new p1290();
        ListNode head = ListUtils.newList(new int[] {1,0,1});
        System.out.println(p.getDecimalValue(head));


    }

    public int getDecimalValue(ListNode head) {
        if (head == null) { return 0; }

        int res = 0;
        ListNode cur = head;
        while(cur != null) {
            res = res * 2 + cur.val;
            cur = cur.next;
        }
        return res;
    }
}

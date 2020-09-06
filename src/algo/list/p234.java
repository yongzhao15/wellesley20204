package algo.list;

import common.ListNode;
import common.ListUtils;

public class p234 {
    public static void main(String[] args) {
        ListNode head = ListUtils.newList(new int[] {1,2,2,1});
        // ListNode head = ListUtils.newList(new int[] {1,2});
        p234 p = new p234();
        System.out.println(p.isPalindrome(head));

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { return true; }
        this.front = head;
        return recur(head);
    }

    private ListNode front;
    private boolean recur(ListNode rear) {
        if (rear == null) {
            return true;
        }

        if (!recur(rear.next) || rear.val != front.val) {
            return false;
        }

        front = front.next;
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) { return true; }

        ListNode head2 = new ListNode(head.val);
        ListNode cur = head.next;
        while(cur != null) {
            head2 = new ListNode(cur.val, head2);
            cur = cur.next;
        }

        ListNode cur1 = head;
        ListNode cur2 = head2;
        while(cur1 != null && cur1.val == cur2.val) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1 == null;
    }

}

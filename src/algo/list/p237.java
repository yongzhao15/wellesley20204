package algo.list;

import common.ListNode;

public class p237 {
    public void deleteNode(ListNode node) {
        if (node == null) { return; }
        if (node.next == null) { return; }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}

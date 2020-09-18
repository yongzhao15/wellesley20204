package algo.list;

import common.ListNode;
import common.ListUtils;
import common.TreeNode;
import common.TreeUtils;

public class p109 {
    public static void main(String[] args) {
        ListNode head = ListUtils.newList(new int[] {0,1,2,3,4,5,6});
        p109 p = new p109();

        System.out.println(TreeUtils.dumpTree(p.sortedListToBST(head)));

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null; }

        int len = getLength(head);
        this.cur = head;
        TreeNode root = build(0, len-1);
        return root;
    }

    private int getLength(ListNode head) {
        if (head == null) { return 0; }
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    ListNode cur;
    private TreeNode build(int left, int right) {
        TreeNode root = null;
        if (left > right) {
            root = null;
        } else if (left == right) {
            root = new TreeNode(cur.val);
            cur = cur.next;
        } else { // left < right
            int mid = (left+right)/2;
            root = new TreeNode(); // init root with dummy value first

            root.left = build(left, mid-1);

            root.val = cur.val; // now we know root's value
            cur = cur.next;

            root.right = build(mid+1, right);
        }

        return root;
    }
}

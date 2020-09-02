package algo.list;

import common.ListNode;
import common.ListUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p817 {
    public static void main(String[] args) {
//        ListNode head = ListUtils.newList(new int[] {0,1,2,3});
//        int[] G = new int[] {0,1,3};

        ListNode head = ListUtils.newList(new int[] {0,1,2,3,4});
        int[] G = new int[] {0,3,1,4};
        p817 p = new p817();
        System.out.println(p.numComponents(head, G));


    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0) {
            return 0;
        }

        Set<Integer> g = new HashSet<>();
        for(int v : G) { g.add(v); }

        int ret = 0;
        ListNode prev = null, curr = head;
        while(curr != null) {
            if (g.contains(curr.val) && (prev == null || !g.contains(prev.val))) {
                ret++;
            }
            prev = curr;
            curr = curr.next;
        }

        return ret;
    }
}

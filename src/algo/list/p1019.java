package algo.list;

import common.ArrayUtils;
import common.ListNode;
import common.ListUtils;

import java.util.*;

public class p1019 {
    public static void main(String[] args) {
        // ListNode head = ListUtils.newList(new int[] {2,1,5});
        // ListNode head = ListUtils.newList(new int[] {2,7,4,3,5});
        ListNode head = ListUtils.newList(new int[] {1,7,5,1,9,2,5,1});
        p1019 p = new p1019();
        System.out.println(ArrayUtils.dumpArray(p.nextLargerNodes(head)));
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) { return null; }

        List<Integer> nums = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            if (st.isEmpty() || nums.get(st.peek()) >= val) {
                st.push(i);
            } else { // st.peek() < nums.get(i)
                while(!st.isEmpty() && nums.get(st.peek()) < val) {
                    int j = st.pop();
                    nums.set(j, val);
                }
                st.push(i);
            }
        }

        while(!st.isEmpty()) {
            nums.set(st.pop(), 0);
        }

        int[] ret = new int[nums.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = nums.get(i);
        }

        return ret;
    }
}
